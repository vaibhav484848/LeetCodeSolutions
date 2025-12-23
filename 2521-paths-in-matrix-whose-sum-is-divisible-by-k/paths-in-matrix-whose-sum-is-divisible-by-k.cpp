class Solution {
public:
    const int mod=1e9+7;
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int m=grid.size();
        int n=grid[0].size();

        vector<vector<vector<int>>>dp(m,vector<vector<int>>(n,vector<int>(k,0)));
        dp[0][0][grid[0][0]%k]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;

                for(int rem=0;rem<k;rem++){
                    /*
                        (prevRem+grid[i][j])%k=currRem
                        prevRem+grid[i][j]=(currRem-grid[i][j]+k)%k
                    */

                    if(i>0){
                        int prevRem=((rem-grid[i][j])%k+k)%k;
                        dp[i][j][rem]=(1ll*dp[i][j][rem]+ dp[i-1][j][prevRem])%mod;
                    }
                    if(j>0){
                        int prevRem=((rem-grid[i][j])%k+k)%k;
                        dp[i][j][rem]=(1ll*dp[i][j][rem]+ dp[i][j-1][prevRem])%mod;
                    }

                } 
            }
        }

        return dp[m-1][n-1][0];
    }
};