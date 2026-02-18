class Solution {
public:

    vector<vector<int>>dp;
    int helper(int st,int end,int l,int r,vector<int>& cuts){
        if(l>r) return 0;

        if(dp[l][r]!=-1) return dp[l][r];

        int len=end-st;

        int cost=1e9;

        for(int i=l;i<=r;i++){
            cost=min(cost,len+helper(st,cuts[i],l,i-1,cuts)+helper(cuts[i],end,i+1,r,cuts));
        }

        return dp[l][r]= cost;
    }
    int minCost(int n, vector<int>& cuts) {
        dp.assign(101,vector<int>(101,-1));
        sort(cuts.begin(),cuts.end());

        return helper(0,n,0,cuts.size()-1,cuts);
    }
};