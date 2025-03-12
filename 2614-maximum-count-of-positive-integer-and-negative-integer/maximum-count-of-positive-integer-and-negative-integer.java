class Solution {
    public int maximumCount(int[] nums) {
        int posCount=0;
        int n=nums.length;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) posCount++;
            if(nums[i]==0) n--;
        }
        return Math.max(posCount,n-posCount);
        
    }
}