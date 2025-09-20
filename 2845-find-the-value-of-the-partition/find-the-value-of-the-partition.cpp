class Solution {
public:
    int findValueOfPartition(vector<int>& nums) {
        #define int long long

        sort(nums.begin(),nums.end());

        int n=nums.size();

        int diff=INT_MAX;

        for(int i=0;i<n-1;i++){
            diff=min((int)(abs(nums[i]-nums[i+1])),diff);
        }
        return diff;

        #undef int 
    }
};