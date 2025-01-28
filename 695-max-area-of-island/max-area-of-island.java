class Solution {

    int m;
    int n;

    class Triplet{
        int x;
        int y;
        int val;

        Triplet(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    boolean isValid(int x,int y,int m,int n){

        if(x<0 || x>=m || y<0 || y>=n  ) return false;
        return true;

    }

    public int maxAreaOfIsland(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;

        int[][] dirn ={{0,-1},{0,1},{1,0},{-1,0}};

        int maxm=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    int sum=0;

                    boolean[][] visited=new boolean[m][n];
                    visited[i][j]=true;

                    Queue<Triplet> q= new LinkedList<>();
                    q.add(new Triplet(i,j,grid[i][j]));

                    while(q.size()>0){

                        Triplet temp=q.remove();
                        int val=temp.val;
                        int x=temp.x;
                        int y=temp.y;

                        sum+=val;

                        for(int ii=0;ii<4;ii++){

                            int x_new = x + dirn[ii][0];
                            int y_new = y + dirn[ii][1];

                            if(isValid(x_new,y_new,m,n) && !visited[x_new][y_new] && grid[x_new][y_new]!=0 ){

                                q.add(new Triplet(x_new,y_new,grid[x_new][y_new]));
                                visited[x_new][y_new]=true;

                            }
                        }
                    }

                    maxm=Math.max(maxm,sum);
                }
            }
        }

        return maxm;
        
    
        
    }
}