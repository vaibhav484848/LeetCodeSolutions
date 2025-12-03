class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        map<int,int>mp;
        int n=nums.size();
        for(int ele:nums)mp[ele]++;

        vector<int>ans;

        for(auto it:mp){
            int ele=it.first;
            if(mp[ele]==1){
                if(!mp[ele-1] && !mp[ele+1]) ans.push_back(ele);
            }
        }
        return ans;
    }
};