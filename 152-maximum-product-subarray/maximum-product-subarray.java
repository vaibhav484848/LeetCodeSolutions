class Solution {
    public int maxProduct(int[] nums) {

        int n=nums.length;

        int pro=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int curr=1;
            for(int j=i;j<n;j++){
                curr*=nums[j];
                pro=Math.max(curr,pro);
            }
        }

        return pro;
        
    }
}