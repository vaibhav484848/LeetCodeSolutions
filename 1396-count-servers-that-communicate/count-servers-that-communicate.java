class Solution {
    public int countServers(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];

        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                //    if(!visited[i][j]){
                //     count++;
                //    }
            
                    boolean flag=false;
                    boolean alreadyVisited=false;

                    if(visited[i][j]) alreadyVisited=true;
                    visited[i][j]=true;
                    int ii=0;
                    int jj=0;
                    while(ii<m){
                        if(grid[ii][j]==1 && ii!=i ){
                            if(!visited[ii][j]){
                                count++;
                                 visited[ii][j]=true;

                            }
                            flag=true;
                            
                        }
                        ii++;
                    }
                   
                    
                    while(jj<n){
                        if(grid[i][jj]==1 && jj!=j){
                            if(!visited[i][jj]){
                                count++;
                                visited[i][jj]=true;
                            }
                            
                            flag=true;
                            
                        }
                        jj++;
                    }

                     if(flag && !alreadyVisited) count++;
                }
            }
        }

        return count;
        
    }
}