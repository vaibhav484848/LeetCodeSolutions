class Solution {
    int[] dirX={1,-1,0,0};
    int[] dirY={0,0,1,-1};

    boolean isValid(int x,int y,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        if(x<m && x>=0 && y<n && y>=0 && grid[x][y]!=0) return true;
        return false;
    }
    int sum;
    void dfs(int i,int j,int[][] grid,boolean[][] visited){
        visited[i][j]=true;

        for(int ii=0;ii<4;ii++){
            int x_new=i+dirX[ii];
            int y_new=j+dirY[ii];
            if(isValid(x_new,y_new,grid) && !visited[x_new][y_new]){
                sum+=grid[x_new][y_new];
                dfs(x_new,y_new,grid,visited);
            }
        }

        // return sum;



    }
    public int countIslands(int[][] grid, int k) {

        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]!=0){
                    sum=grid[i][j];
                    dfs(i,j,grid,visited);
                    if(sum%k==0){
                        count++;
                    }
                }
            }
        }

        return count;
        
    }
}