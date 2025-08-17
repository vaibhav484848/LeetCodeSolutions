class Solution {
public: 
    const int MOD=1e9+7;
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        for(auto q:queries){
            for(int i=q[0];i<=q[1];i+=q[2]){
                nums[i]=1ll*nums[i]*q[3]%MOD;
            }
        }
        

        int xorr=0;

        for(int i=0;i<nums.size();i++){
            xorr^=nums[i];
        }

        return xorr;
    }
};