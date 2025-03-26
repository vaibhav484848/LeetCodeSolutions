class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=nums[(nums.length-1)/2];

        int count=0;
        for(int ele:nums){
            count+=Math.abs(mid-ele);
        }
        return count;
    }
}