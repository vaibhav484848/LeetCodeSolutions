class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int n=nums.length;

        int i=1,maxLen=1;

        while(i<n){
            int len=1;

            if(nums[i]==nums[i-1]){
                i++;
                continue;
            }

            while(i<n && nums[i]>nums[i-1]){
                len++;
                i++;
            }
            maxLen=Math.max(maxLen,len);

            len=1;

            while(i<n && nums[i]<nums[i-1]){
                len++;
                i++;
            }

            

            maxLen=Math.max(maxLen,len);


        }

        return maxLen;
        
    }
}