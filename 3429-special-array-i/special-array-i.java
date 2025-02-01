class Solution {
    public boolean isArraySpecial(int[] nums) {
        int prev=nums[0]%2==0?0:1;

        for(int i=1;i<nums.length;i++){
            int curr=nums[i]%2==0?0:1;
            if(curr==prev) return false;

            prev=curr;
        }

        return true;


    }
}