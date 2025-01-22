class Solution {

    class Triplet{
        int val;
        int x;
        int y;

        Triplet(int val,int x,int y){
            this.val=val;
            this.x=x;
            this.y=y;
        }
    }
    
    boolean isValid(int i,int j,int[][] arr){
        if(i>=arr.length || j>=arr[0].length || i<0 || j<0 ) return false;
        return true;
    }
    public int[][] highestPeak(int[][] isWater) {
        int[][] dirn={{-1,0},{1,0},{0,-1},{0,1}};

        int m=isWater.length;
        int n=isWater[0].length;

        boolean[][] visited=new boolean[m][n];

        Queue<Triplet> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1) {
                    q.add(new Triplet(0,i,j));
                    isWater[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }

        while(q.size()>0){
            Triplet t=q.remove();
            int val=t.val;
            int x=t.x;
            int y=t.y;

            for(int i=0;i<4;i++){
                int x_new=x+dirn[i][0];
                int y_new=y+dirn[i][1];

                if(isValid(x_new,y_new,isWater) && !visited[x_new][y_new]){
                    visited[x_new][y_new]=true;
                    isWater[x_new][y_new]=val+1;
                    q.add(new Triplet(val+1,x_new,y_new));
                }
            }
        }

        return isWater;
        
    }
}