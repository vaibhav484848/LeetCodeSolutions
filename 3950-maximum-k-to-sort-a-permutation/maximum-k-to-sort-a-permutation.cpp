class Solution {
public:
    int sortPermutation(vector<int>& nums) {
        vector<int> v;
        int n=nums.size();
        for(int i=0;i<n;i++){
            if(nums[i]!=i) v.push_back(i);
        }
        if(v.size()==0) return 0;
        int ans=v[0];
        for(int i=1;i<v.size();i++){
            ans&=v[i];
        }
        return ans;
    }
};