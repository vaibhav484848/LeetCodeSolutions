class Solution {
    int find(int i,int[] parent){
        if(i==parent[i]) return i;

        return parent[i]=find(parent[i],parent);
    }
    void union(int a,int b,int[] parent,int[] size){

        int a_parent=find(a,parent);
        int b_parent=find(b,parent);

        if(a_parent==b_parent) return ;

        if(size[a_parent]>size[b_parent]){
            size[a_parent]+=size[b_parent];
            parent[b_parent]=parent[a_parent];
        }
        else if(size[b_parent]>size[a_parent]){
            size[b_parent]+=size[a_parent];
            parent[a_parent]=parent[b_parent];
        }
        else{
            size[a_parent]+=size[b_parent];
            parent[b_parent]=parent[a_parent];
            
        }
    }

    int[][] dirn={{-1,0},{1,0},{0,-1},{0,1}};

    boolean isValid(int x,int y,int n){
        if(x<0 || x>=n || y<0 || y>=n )  return false;
        return true;
    }

    public int largestIsland(int[][] grid) {

        int total=0;
        
        int n=grid.length;

        int[] parent= new int[n*n];
        int [] size=new int[n*n];
        Arrays.fill(size,1);

        for(int i=0;i<n*n;i++) parent[i]=i;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    
                    for(int ii=0;ii<4;ii++){
                        int x_new=i+dirn[ii][0];
                        int y_new=j+dirn[ii][1];

                        if(isValid(x_new,y_new,n) && grid[x_new][y_new]==1){
                            int a=j+(n*i);
                            int b=y_new + (x_new *n);
                            union(a,b,parent,size);
                        }
                    }
                }
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int max=0;
                HashSet<Integer> set= new HashSet<>();
                if(grid[i][j]==0){
                    
                    for(int ii=0;ii<4;ii++){

                        int x_new=i+dirn[ii][0];
                        int y_new=j+dirn[ii][1];

                        if(isValid(x_new,y_new,n) && grid[x_new][y_new]==1){

                            int idx=x_new*n + y_new;

                            // int prnt=parent[idx];
                            int prnt=find(idx,parent);
                            if(set.contains(prnt)) continue;

                            set.add(prnt);

                            max+=size[prnt];
                           
                        }


                    }
                    total=Math.max(total,max+1);
                    
                }
            }
        }

        if(total==0) return n*n;

        return total;
        
    }
}