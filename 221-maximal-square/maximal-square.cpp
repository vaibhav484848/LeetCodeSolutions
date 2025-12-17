class Solution {
public:
    int dp[301][301];

    int rec(int i,int j,vector<vector<char>>& matrix){
        if(i==0 || j==0) return dp[i][j];

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if(matrix[i][j]=='0'){
            return dp[i][j]=0;
        }

        return dp[i][j] = 1+min({rec(i-1,j,matrix),rec(i,j-1,matrix),rec(i-1,j-1,matrix)});
    }
    int maximalSquare(vector<vector<char>>& matrix) {
        memset(dp,-1,sizeof(dp));

        int m=matrix.size();
        int n=matrix[0].size();

        int ans=0;

        for(int i=0;i<m;i++){
            dp[i][0]=matrix[i][0]-'0';
            ans=max(ans,dp[i][0]);
        }

        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i]-'0';
            ans=max(ans,dp[0][i]);
        }

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         dp[i][j]=matrix[i][j]-'0';
        //     }
        // }

        // rec(m-1,n-1,matrix);

        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) continue;
                ans=max(ans,rec(i,j,matrix));
            }
        }

        

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         cout<<dp[i][j]<<" ";
        //         ans=max(ans,dp[i][j]);
        //         // cout<<i<<" "<<j<<" "<<ans<<endl;
        //     }
        //     cout<<endl;
        // }
        return ans*ans;
    }
};