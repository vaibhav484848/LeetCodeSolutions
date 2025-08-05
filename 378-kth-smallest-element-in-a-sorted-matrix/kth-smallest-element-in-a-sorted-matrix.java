class Solution {
    class Pair{
        int x;
        int y;
        int val;

        Pair(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;

        int count=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        boolean[][] visited =new boolean[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],false);
        }

        pq.add(new Pair(0,0,matrix[0][0]));
        visited[0][0]=true;

        while(pq.size()>0){
            Pair p = pq.remove();

            count++;

            if(count==k) return p.val;

            int x=p.x;
            int y=p.y;
            

            if(y+1<n && !visited[x][y+1]){
                visited[x][y+1]=true;
                pq.add(new Pair(x,y+1,matrix[x][y+1]));
                
            }
            if(x+1<n && !visited[x+1][y]){
                visited[x+1][y]=true;
                pq.add(new Pair(x+1,y,matrix[x+1][y]));
            }
        }

        return -1;

    }
    
    
}