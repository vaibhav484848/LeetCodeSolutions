class Solution {
    public int maxArea(int[] height) {
        int n=height.length;

        // return 32;

        // int[] pre=new int[]

        int i=0,j=height.length-1;

        int water=0;

        while(i<j){
            while(height[j]>height[i]){
                water=Math.max(water,(j-i)*height[i]);
                i++;
            }
            if(height[j]<=height[i]){
                water=Math.max(water,(j-i)*height[j]);
                j--;
            }
        }

        return water;
        
    }
}