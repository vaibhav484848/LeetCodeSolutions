class Solution {
public:
    
    long long maxSubarraySum(vector<int>& nums, int k) {
        #define int long long
        int n=nums.size();
        int currSum=0;
        vector<int>minSeen(n,1e9);
        minSeen[k-1]=0;
        int ans=LONG_MIN;

        for(int i=0;i<n;i++){
            currSum+=nums[i];
            
            
            if(i>=k-1){
                ans=max(ans,currSum-minSeen[i%k]);
            }
            minSeen[i%k]=min(minSeen[i%k],currSum);

        }
        return ans;

        #undef int
       
    }
};