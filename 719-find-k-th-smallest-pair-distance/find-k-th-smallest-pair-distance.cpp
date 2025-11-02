class Solution {
public:
    int check(int diff,vector<int>& nums,int k){

        int n=nums.size();
        int count=0;

        for(int i=0;i<n;i++){
            int ele=nums[i];

            int lo=i+1;
            int hi=n-1;
            int ans=-1;

            while(lo<=hi){
                int mid=lo+(hi-lo)/2;

                if(nums[mid]-ele<=diff){
                    ans=mid;
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
            if(ans!=-1)
            count+=(ans-i);
        }
        // cout<<count<<" count: "<<diff<<" mid\n";
        return count>=k;
    }
    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());

        int lo=0,hi=1e6,ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(check(mid,nums,k)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }

        return ans;
    }
};