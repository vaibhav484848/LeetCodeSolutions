class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        #define int long long
        int n=nums.size();

        map<int ,int> map;

        // for(int i=0;i<n;i++) nums[i]%=k;

        int sum=0;
        for(int i=0;i<n;i++){
            nums[i]%=k;
            sum+=nums[i];

            if(sum%k==0 && i>=1) return true;

            if(map.find(sum%k)!=map.end() && i-map[sum%k]>=2) return true;

            if(map.find(sum%k)==map.end())map[sum%k]=i;
        }
        return false;

        #undef int
    }
};