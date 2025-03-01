class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];

        int i=0;
        int idx=0;

        while(i<n-1){
            if(nums[i]==0) {
                i++;
                continue;
            }
            if(nums[i]==nums[i+1] ) {
                ans[idx]=2*nums[i];
                i++;
            }
            else{
                if(i<n)
                ans[idx]=nums[i];
            }
            idx++;
            i++;

        }
        if(nums[n-2]!=nums[n-1])
        ans[idx]=nums[n-1];

        return ans;
    }
}