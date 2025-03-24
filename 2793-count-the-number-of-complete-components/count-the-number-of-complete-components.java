class Solution {

    int countVis;
    Set<Integer> set;

    void dfs(int node,boolean[] visited,List<List<Integer>> adj,int parent){
        visited[node]=true;
        set.add(node);

        for(int ele:adj.get(node)){
            if(!visited[ele]){
                
                dfs(ele,visited,adj,node);
            }
            
        }
        
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int eL=edges.length;

        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<eL;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        // System.out.println(adj.get(0));
        boolean[] visited=new boolean[n];

        int count=0;

        for(int i=0;i<n;i++){
            countVis=0;
            set=new HashSet<>();
            if(!visited[i]){
                dfs(i,visited,adj,-1);
                boolean flag=true;
                for(int ele:set){
                    if(adj.get(ele).size()!=set.size()-1) {
                        flag=false;
                        break;
                    }
                }
                if(flag) count++;
                
            }
        }

        return count;
    }
}