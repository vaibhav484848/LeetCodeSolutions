class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;

        int[] pre =new int[n];
        int[] suff =new int[n];

        pre[0]=nums[0];
        suff[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i];
        }

        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]*nums[i];
        }
        int prev=1;
        int after=1;

        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            prev=1;
            after=1;
            if(i!=0){
                prev=pre[i-1];
            }
            if(i!=n-1) after=suff[i+1];

            ans[i]=prev*after;
        }

        return ans;
        
    }
}