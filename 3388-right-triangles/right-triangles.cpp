class Solution {
public:
    long long numberOfRightTriangles(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>>prefixSR(n,vector<int>(m,0));
         vector<vector<int>>prefixSC(n,vector<int>(m,0));

        for(int i=0;i<n;i++){
           prefixSR[i][0]= grid[i][0];
        }
        for(int i=0;i<m;i++){
           prefixSC[0][i]= grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                prefixSR[j][i]=prefixSR[j][i-1]+grid[j][i];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                prefixSC[i][j]=prefixSC[i-1][j]+grid[i][j];
            }
        }


        long long count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int rOne=prefixSR[i][m-1]-prefixSR[i][j] + ((j>0)?prefixSR[i][j-1]:0);
                    int cOne=prefixSC[n-1][j]-prefixSC[i][j] + ((i>0)?prefixSC[i-1][j]:0);

                    count+=(rOne*cOne);
                }
            }
        }

        return count;


    }
};