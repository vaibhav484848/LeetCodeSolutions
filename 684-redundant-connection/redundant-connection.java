class Solution {
    
    int dfs(int node,int parent,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;

        for(int ele:adj.get(node)){
            if(!visited[ele]){
                int num=dfs(ele,node,adj,visited);
                if(num!=-1) return num;
            }
            else{
                if(ele!=parent){
                    return ele;
                }
            }
        }

        return -1;
    }
    public int[] findRedundantConnection(int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=1000;i++) adj.add(new ArrayList<>());

        int ele=edges[0][0];

        

        for(int i=0;i<edges.length;i++){
            boolean[] visited=new boolean[1001];
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
             adj.get(b).add(a);
             int num=dfs(a,-1,adj,visited);
            //  System.out.println(num);
             if(num!=-1) return new int[]{a,b};
            
        }
        
        return new int[]{-1,-1} ;
    }
        
        
    
}