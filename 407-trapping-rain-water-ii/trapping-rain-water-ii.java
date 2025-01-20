class Solution {
    class Triplet{
        int val;
        int x;
        int y;

        Triplet(int val, int x,int y){
            this.val=val;
            this.x=x;
            this.y=y;

        }
    }

    boolean isValid(int x,int y,int m,int n){
        if(x<0 || x>=m || y<0 || y>=n) return false;
        return true;
    }

    public int trapRainWater(int[][] heightMap) {

        int[][] dirn={{0,-1},{0,1},{-1,0},{1,0}};

        PriorityQueue<Triplet> pq=new PriorityQueue<>((a,b)->{
           return a.val-b.val;
        });

        int m=heightMap.length;
        int n=heightMap[0].length;

        boolean[][] visited=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    visited[i][j]=true;
                    pq.add(new Triplet(heightMap[i][j],i,j));
                }

            }
        }

        int water=0;
        
        while(pq.size()>0){
            Triplet t=pq.remove();
            int val=t.val;
            int x=t.x;
            int y=t.y;

            for(int i=0;i<4;i++){
                int x_new=x+dirn[i][0];
                int y_new=y+dirn[i][1];
                if(isValid(x_new,y_new,m,n) && !visited[x_new][y_new]){
                    int waterAdd=Math.max(0,val-heightMap[x_new][y_new]);
                    water+=waterAdd;
                    visited[x_new][y_new]=true;
                    pq.add(new Triplet(Math.max(val,heightMap[x_new][y_new]),x_new,y_new));
                }
            }
        }

        return water;
    }
}