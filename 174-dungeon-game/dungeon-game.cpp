class Solution {
public:
    int dp[201][201];
    int done[201][201];

    int m,n;

    int rec(int i,int j,vector<vector<int>>& dungeon){
        if(i>=m || j>=n){
            return -1e9;
        }
        if(i==m-1 && j==n-1){
            return min(0,dungeon[i][j]); 
        }
        if(done[i][j]){
            return dp[i][j];
        }
        int a=rec(i+1,j,dungeon);
        int b=rec(i,j+1,dungeon);
        
        done[i][j]=1;
        return dp[i][j]=min(0,max(a,b)+dungeon[i][j]);
    }
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        m=dungeon.size();
        n=dungeon[0].size();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                done[i][j]=0;
                dp[i][j]=0;
            }
        }
        int ans=rec(0,0,dungeon);
        return max(1,1-ans);
    }
};