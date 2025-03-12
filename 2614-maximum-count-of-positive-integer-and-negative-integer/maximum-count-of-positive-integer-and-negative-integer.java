class Solution {
    int lowerBound(int[] nums){
        int lo=0,hi=nums.length-1;
        int ans=-1;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==0){
                hi=mid-1;
            }
            else if(nums[mid]<0){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    int upperBound(int[] nums){
        int lo=0,hi=nums.length-1;
        int ans=-1;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==0)lo=mid+1;
            if(nums[mid]>0){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int lB=lowerBound(nums)+1;
        
        
        int uB=upperBound(nums);
        if(uB==-1) uB=0;
        else{
            uB=n-uB;
        }

        return Math.max(uB,lB);
        
    }
}