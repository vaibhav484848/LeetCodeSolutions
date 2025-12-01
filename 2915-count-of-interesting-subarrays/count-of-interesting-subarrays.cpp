class Solution {
public:
    long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
        int n=nums.size();

        long long sum=0,ans=0;

        map<int,int>mp;
        mp[0]=1;

        for(int i=0;i<n;i++){
            sum+=((nums[i]%modulo)==k);


            //(sum-prev)%modulo==k;
            //(sum-k)%modulo=prev%modulo

            if(mp.find((sum%modulo-k%modulo + modulo)%modulo)!=mp.end()){
                ans+=mp[(sum%modulo-k%modulo + modulo)%modulo];
            }
            mp[sum%modulo]++;

            
        }

        return ans;
    }
};