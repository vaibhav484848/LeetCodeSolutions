class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int[] pre= new int[n];
        int[] nex=new int[n];

        pre[0]=0;

        for(int i=1;i<n;i++){

            pre[i]=Math.max(pre[i-1],height[i-1]);


        }

        nex[n-1]=0;

        for(int i=n-2;i>=0;i--){

            nex[i]=Math.max(nex[i+1],height[i+1]);

        }

        int sum=0;

        for(int i=0;i<n;i++){
            if(height[i]>pre[i] || height[i]>nex[i]) continue;
            else{
                sum+=Math.min(pre[i],nex[i])-height[i];
            }
        }

        return sum;
        
    }
}