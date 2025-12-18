class Solution {
public:
    const int mod=1e9+7;
    int kk;
    int rec(int i,int j,int rem,vector<vector<int>>& grid,vector<vector<vector<int>>>& dp){
        if(i==0 && j==0){
            rem+=grid[i][j];
            rem%=kk;
            if(rem==0) return 1;
            return 0;
        }
        if(i<0 || j<0) return 0;

        if(dp[i][j][rem]!=-1) return dp[i][j][rem];

        int newRem=(rem+grid[i][j])%kk;

        long long a=rec(i-1,j,newRem,grid,dp);
        long long b=rec(i,j-1,newRem,grid,dp);

        return dp[i][j][rem]=(a+b)%mod;
    }
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int m=grid.size();
        int n=grid[0].size();

        kk=k;

        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k + 1, -1)));

        return rec(m-1,n-1,0,grid,dp);
    }
};