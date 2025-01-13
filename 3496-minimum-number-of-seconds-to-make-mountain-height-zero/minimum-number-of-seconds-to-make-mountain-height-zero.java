class Solution {
    boolean check(long value,int height,int[] arr){
        long remHeight=0;

        for(int i=0;i<arr.length;i++){
            long lo=1;
            long hi=height;

            long ans=-1;

            while(lo<=hi){

                long mid=lo+(hi-lo)/2;

                // if (mid > (2 * value / arr[i])) { // Overflow prevention
                //     hi = mid - 1;
                //     continue;
                // }

                if((long)arr[i]*(mid)*(mid+1)/2L<=value){
                    ans=mid;
                    lo=mid+1;
                }
                    

                // if((long)arr[i]*(mid)/2L<=(value/(mid+1))){
                //     ans=mid;
                //     lo=mid+1;
                // }
                else{
                    hi=mid-1;
                }

            }
            // if(ans==-1 || ans>value) return false;
            remHeight+=ans;
            if(remHeight>=height) return true;
        }

        return remHeight>=height;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long  lo=0;
        long hi=Long.MAX_VALUE;

        Arrays.sort(workerTimes);

        long ans=-1;

        while(lo<=hi){
             long mid=lo+(hi-lo)/2;

            if(check(mid,mountainHeight,workerTimes)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
            
        }


        return ans;
        
    }
}