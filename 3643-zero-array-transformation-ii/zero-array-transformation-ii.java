class Solution {
    boolean zeroArr(int mid,int[] nums,int[][] queries){
        int n=nums.length;
        int[] diffArr=new int[n];

        for(int i=0;i<=mid;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int c=queries[i][2];

            diffArr[a]+=c;
            if(b+1<n) diffArr[b+1]-=c;
        }

        for(int i=1;i<n;i++){
            diffArr[i]+=diffArr[i-1];
            if(diffArr[i]<nums[i]) return false;
        }
        if(diffArr[0]<nums[0]) return false;
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int ans=-1;
        
        int qL=queries.length;

        int lo=0,hi=qL-1;
        if(zeroArr(-1,nums,queries)) return 0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(zeroArr(mid,nums,queries)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return ans==-1?-1:ans+1;
    }
}