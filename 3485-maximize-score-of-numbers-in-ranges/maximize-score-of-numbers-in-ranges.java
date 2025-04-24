class Solution {
    boolean check(int mid,int[] start,int d){
        int n=start.length;
        int prev=start[0];
        int end=start[n-1]+d;

        for(int i=1;i<n-1;i++){
            if(prev+mid>start[i]+d) return false;
            if(prev+mid<start[i]) prev=start[i];
            else prev=prev+mid;
        }
        if(prev+mid>end) return false;
        return true;
    }
    public int maxPossibleScore(int[] start, int d) {

        Arrays.sort(start);

        int lo=0;
        int hi=Integer.MAX_VALUE;

        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(check(mid,start,d)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;


        
    }
}