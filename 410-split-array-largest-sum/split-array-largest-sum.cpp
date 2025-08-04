class Solution {
public:
    int check(int mid,int k,vector<int>& nums){
        int part=1;
        int sum=0;
        for(int ele:nums){
            sum+=ele;
            if(sum>mid){
                sum=ele;
                if(sum>mid) return false;
                part++;
            }
            if(part>k) return false;
        }
        return true;
    }
    int splitArray(vector<int>& nums, int k) {
        int lo=0;
        int hi=1e9;

        int ans=-1;


        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(check(mid,k,nums)==0){
                lo=mid+1;
            }
            else{
                ans=mid;
                hi=mid-1;
            }
        }

        return ans;
    }
};