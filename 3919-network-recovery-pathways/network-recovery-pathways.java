class Solution {

    class Pair{
        int node;
        long dist;

        Pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    boolean flag;
    long maxi=-1;
    void dfs(int node,List<List<Pair>> adj,long minm,int fNode,long sum,long k){
        if(minm<=maxi) return;
        if(node==fNode ){
            if(sum<=k) {
                flag=true;
                maxi=Math.max(maxi,minm);
                // return minm;
                return;
            }
            
            
            return;
        }
        // visited[node]=true;
        long maximum=Long.MIN_VALUE;
        for(Pair temp:adj.get(node)){
            if(sum+temp.dist<=k){
                
                dfs(temp.node,adj,Math.min(minm,temp.dist),fNode,sum+temp.dist,k);
            }
            
        }
        // visited[node]=false;
        // return maximum;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        flag=false;

        List<List<Pair>> adj=new ArrayList<>();
        int n=online.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){

            int a=edges[i][0];
            int b=edges[i][1];
            int c=edges[i][2];
            if(!online[a]) continue;

            adj.get(a).add(new Pair(b,c));

        }
        // boolean[] visited=new boolean[n];

        dfs(0,adj,Integer.MAX_VALUE,n-1,0,k);

        if(!flag) return -1;

        return (int)(maxi);

        
        
    }
}