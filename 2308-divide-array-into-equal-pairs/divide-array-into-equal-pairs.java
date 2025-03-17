class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq=new int[501];
        for(int ele:nums){
           freq[ele]++;
        }
        for(int ele:freq){
            if(ele%2!=0) return false;
        }
        return true;
    }
}