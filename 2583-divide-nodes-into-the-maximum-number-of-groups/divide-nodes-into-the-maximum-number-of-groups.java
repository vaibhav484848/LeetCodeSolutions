class Solution {
    boolean isBipartite(int node,int color,int parent, List<List<Integer>> adj,int[]visited,List<Integer> component){

        visited[node]=color;
        component.add(node);

        for(int ele:adj.get(node)){
            if(visited[ele]==-1){
                if(isBipartite(ele,1-color,node,adj,visited,component)) return true;;
            }
            else{
                if(ele!=parent && visited[ele]==color) return true;
            }
        }
        return false;
    }

    int bfs(int node,List<List<Integer>> adj,int[] visited){
        visited[node]=1;

        Queue<Integer> q=new LinkedList<>();
        q.add(node);

        int count=0;

        while(q.size()>0){
            

            int n=q.size();

            count++;

            while(n-->0){
                

                int Node=q.remove();

                for(int ele:adj.get(Node)){
                    if(visited[ele]==0){
                        visited[ele]=1;
                        q.add(ele);
                    }
                    
                }

            }
            
        }

        return count;
    }
    public int magnificentSets(int n, int[][] edges) {

        //CycleOdd -> -1
       

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] visited=new int[n+1];
        Arrays.fill(visited,-1); 
        
        int total=0;
        

        List<Integer> component=new ArrayList<>();

        for(int i=1;i<=n;i++){
            
            if(visited[i]==-1){
                component.clear();
                if(isBipartite(i,0,-1,adj,visited,component)){
                    return -1;
                }

                int maxm=0;

                

                for(int ele:component){
                    int[] newVisited=new int[n+1];
                    maxm=Math.max(maxm,bfs(ele,adj,newVisited));
                }

                total+=maxm;
                
            }
            
        }

        // for(int i=1;i<=n;i++){
        //     Arrays.fill(visited,0);
        //     maxm=Math.max(maxm,bfs(i,adj,visited));
            
        // }

        return total;

     
    }
}