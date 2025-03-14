class Solution {
    boolean checker(int mid,int[] candies,long k){
        
        long count=0;
        for(int i=0;i<candies.length;i++){
            count+=(candies[i]/mid);
        }
        if(count>=k) return true;
        return false;

    }
    public int maximumCandies(int[] candies, long k) {

        // 1-> Maxm B.S=> 5 ans then 4 but not 6

        int n=candies.length;

        int lo=1;
        int hi=10000005;

        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(checker(mid,candies,k)){
                lo=mid+1;
                ans=mid;
            }
            else{
                hi=mid-1;
            }

            
        }

        return ans;

        
    }
}