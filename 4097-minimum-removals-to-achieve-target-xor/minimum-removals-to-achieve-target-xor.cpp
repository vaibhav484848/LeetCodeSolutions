class Solution {
public:

// dp[idx][target]-> maxm num of elements to include from idx to n such that k xor of elements is target or we can say 
//target becomes 0

    map<pair<int,int>,int>mp;

    int rec(int idx, int target,vector<int>&nums){
        if(idx>=nums.size()){
            if(target==0) return 0;
            return -1e9;
        }
        if(mp.count({idx,target})){
            return mp[{idx,target}];
        }

        int pick=1+rec(idx+1,target^nums[idx],nums);
        int skip=rec(idx+1,target,nums);

        return  mp[{idx,target}]= max(pick,skip);
    }

    int minRemovals(vector<int>& nums, int target) {
        
        int ans=nums.size()-rec(0,target,nums);
        if(ans>40) return -1;
        return ans;

    }
};