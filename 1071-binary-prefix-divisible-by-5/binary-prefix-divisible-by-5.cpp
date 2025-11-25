class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {

        vector<bool>ans;

        int rem=nums[0];
        ans.push_back(rem==0);

        for(int i=1;i<nums.size();i++){
            rem=rem*2+nums[i];
            ans.push_back(rem%5==0);
            rem=rem%5;
        }

        return ans;
        
    }
};