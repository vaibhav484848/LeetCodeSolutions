class Solution {
public:
    int minOperations(vector<int>& nums) {
        map<int,int>mp;
        int n=nums.size();

        for(int i=0;i<n;i++){
            mp[nums[i]]++;
        }
        int op=0;
        int idx=0;
        int remEl=n;
        while(mp.size()!=remEl){
            if(idx+3>=n){
                op++;
                break;
            }
            for(int i=idx;i<min(n,idx+3);i++){
                mp[nums[i]]--;
                if(mp[nums[i]]==0)mp.erase(nums[i]);
            }
            idx+=3;
            op++;
            remEl-=3;
        }

        return op;
    }
};