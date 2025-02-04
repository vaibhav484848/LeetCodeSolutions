class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;

        int[] rightMax=new int[n];
        rightMax[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(nums[i],rightMax[i+1]);
        }

        int maxWidth=0;

        int j=0,i=0;


        while(j<n){
            while(j<n && nums[i]<=rightMax[j]){
                maxWidth=Math.max(j-i,maxWidth);
                j++;
            }
            i++;
        }

        return maxWidth;
        
    }
}