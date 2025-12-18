class Solution {
public:
    int n;
    int dp[1001][1001];

    int rec3(int i,int j,vector<vector<int>>& fruits){
        if(i==n-1 && j==n-1){
            return 0;
        }
        if(j>=i || i>=n || j>=n) return -1e9;


        if(dp[i][j]!=-1) return dp[i][j];

        int a=rec3(i-1,j+1,fruits);
        int b=rec3(i,j+1,fruits);
        int c=rec3(i+1,j+1,fruits);

        return dp[i][j]= fruits[i][j]+max({a,b,c});
    }
    
    int rec2(int i,int j,vector<vector<int>>& fruits){
        if(i==n-1 && j==n-1){
            return 0;
        }
        if(j<=i || i>=n || j>=n) return -1e9;

        if(dp[i][j]!=-1) return dp[i][j];

        int a=rec2(i+1,j-1,fruits);
        int b=rec2(i+1,j,fruits);
        int c=rec2(i+1,j+1,fruits);

        return dp[i][j]= fruits[i][j]+max({a,b,c});

    }


    int maxCollectedFruits(vector<vector<int>>& fruits) {
        n=fruits.size();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        int i=0,j=0,sum=0;
        while(i<n){
            sum+=fruits[i][j];
            i++;
            j++;
        }
        
        int a=rec3(n-1,0,fruits);
        int b=rec2(0,n-1,fruits);

        return sum+a+b;
        
    }
};