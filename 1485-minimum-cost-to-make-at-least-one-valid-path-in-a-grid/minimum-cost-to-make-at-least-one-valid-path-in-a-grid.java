class Solution {
    int[][] dirn={{0,0},{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;

    boolean isValid(int x,int y){
        if(x>=m || y>=n || x<0 || y<0) return false;
        return true;
    }

    class Triplet{
        int x;
        int y;
        int weight;
        // int way;

        Triplet(int x,int y,int weight){
           
            this.x=x;
            this.y=y;
            this.weight=weight;
        }
    }
    public int minCost(int[][] grid) {

        PriorityQueue<Triplet> pq=new PriorityQueue<>((a,b)->{
            return a.weight-b.weight;

        });

        m=grid.length;
        n=grid[0].length;

        boolean[][] visited=new boolean[m][n];

        int[][] distance=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);



        pq.add(new Triplet(0,0,0));
        // distance[0][0]=0;
        // visited[0][0]=true;

        while(pq.size()>0){
            Triplet t=pq.remove();
            
            int x=t.x;
            int y=t.y;
            int weight=t.weight;

            if(!visited[x][y]){
                visited[x][y]=true;
            }
            else continue;



            // System.out.println(weight+" x"+x+" y"+y);

            if(x==m-1 && y==n-1) return weight;

            

            for(int i=1;i<=4;i++){
                int flag=1;

                int x_new=x+dirn[i][0];
                int y_new=y+dirn[i][1];

                if(grid[x][y]==i) flag=0;


                if(isValid(x_new,y_new) ){
                    if(!visited[x_new][y_new]){
                        pq.add(new Triplet(x_new,y_new,weight+flag));

                    }
                     
                    //  distance[x_new][y_new]=weight+flag;
                    //  visited[x_new][y_new]=true;
                }
            }
        }
        
        return -1;


        
    }
}