class Solution {
public:
    long long maxSubarraySum(vector<int>& nums, int k) {
        map<int,long long>mp;
        mp[0]=0;

        long long n=nums.size(),sum=0,ans=LONG_MIN;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=(i+1)%k;

            

            if(mp.find(rem)!=mp.end()){
                ans=max(ans,sum-mp[rem]);
                mp[rem]=min(mp[rem],sum);
            }
            else{
                mp[rem]=sum;
            }

        }

        return ans;
    }
};