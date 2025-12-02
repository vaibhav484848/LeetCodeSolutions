class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        map<int,int>mp;

        long long ans=0;

        for(int i=0;i<nums.size();i++){
            long long toFd=nums[i]-i;

            ans+=(i-mp[toFd]);

            mp[toFd]++;
        }

        return ans;
    }
};

