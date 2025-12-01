class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        map<int,int>mp;

        int n=nums.size();

        int ans=0,sum=0;

        for(int i=0;i<n;i++){
            sum=sum+nums[i];

            int rem=(sum%k + k)%k;

            if(rem==0) ans++;

            ans+=mp[rem];

            mp[rem]++;
        }

        return ans;


    }
};

// ((sum at i) - (sum before))%k==0