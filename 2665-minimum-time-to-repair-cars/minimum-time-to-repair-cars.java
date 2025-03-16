class Solution {
    boolean valid(long middle,int[] ranks,int cars){
        

       for(int i=0;i<ranks.length;i++){
        int ans=0;
        int lo=1,hi=cars;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if((long)ranks[i]*mid*mid>middle){
                hi=mid-1;
            }
            else{
                lo=mid+1;
                ans=mid;
            }
            
        }
        cars-=ans;
        if(cars<=0) return true;
       }
       return cars<=0;
    }
    public long repairCars(int[] ranks, int cars) {
        // int lo=cars,int hi;
        long lo=1,hi=(long)1e18;

        long ans=(long)1e18;

        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(valid(mid,ranks,cars)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }

        return ans;
        
    }
}