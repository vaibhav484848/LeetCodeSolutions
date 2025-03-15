class Solution {
    boolean valid(int mid,int[] nums,int k)
    {
        int prevIdx=-2;
        int count=0;

        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            if(ele<=mid && prevIdx!=i-1){
                count++;
                if(count>=k) return true;
                prevIdx=i;
            }
        }
        return count>=k;
    }
    public int minCapability(int[] nums, int k) {

        // 1-> No DP -> n*k(around 10^10) tle
        // 2-> Max-Min BS

        int lo=1,hi=1000000009;

        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(valid(mid,nums,k)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }

        return ans;


        
    }
}