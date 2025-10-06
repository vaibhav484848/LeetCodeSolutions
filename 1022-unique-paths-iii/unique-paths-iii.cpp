class Solution {
public:
    int dx[4] = { -1, 1, 0, 0 };
    int dy[4] = { 0, 0, -1, 1 }; 
    
    bool isValid(int i,int j,vector<vector<int>>& grid){
        if(i>=grid.size() || i<0 || j>=grid[0].size() || j<0 ) return false;
        return true;
    }

    int helper(int steps,int x1,int y1,int x2,int y2,vector<vector<int>>& grid){
        if(steps==0){
            if(x1==x2 && y1==y2) return 1;
            return 0;
        }
        // int poss=grid[x1][y1];
        grid[x1][y1]=100;

        int ans=0;

        for(int i=0;i<4;i++){
            int x_new=x1+dx[i];
            int y_new=y1+dy[i];

            if(isValid(x_new,y_new,grid) && (grid[x_new][y_new]==0 || grid[x_new][y_new]==2)){
                ans+=helper(steps-1,x_new,y_new,x2,y2,grid);
            }
        }
        grid[x1][y1]=0;

        return ans;
    }

    int uniquePathsIII(vector<vector<int>>& grid) {
        int countObs=0;
        int stX=-1;
        int stY=-1;

        int endX=-1;
        int endY=-1;

        int m=grid.size();
        int n=grid[0].size();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==-1) countObs++;
                else if(grid[i][j]==2){
                    endX=i;
                    endY=j;
                }
                else if(grid[i][j]==1){
                    stX=i;
                    stY=j;
                }
            }
        }
        int steps=(m*n)-countObs-1;

        int count=helper(steps,stX,stY,endX,endY,grid);

        return count;
    }
};