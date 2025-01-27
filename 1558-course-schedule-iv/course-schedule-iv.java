class Solution {

    void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;

        for(int ele:adj.get(node)){
            if(!visited[ele]){
                dfs(ele,adj,visited);
            }
        }
    }
    
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        int n=numCourses;

        int[] parent=new int[n];
        int[] rank= new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];

            adj.get(a).add(b);

            // union(a,b,parent,rank);
        }

        int qL=queries.length;

        List<Boolean> ans=new ArrayList<>();

        for(int i=0;i<qL;i++){
            int a=queries[i][0];
            int b=queries[i][1];

            boolean [] visited=new boolean[n];

            dfs(a,adj,visited);
            if(visited[b]) ans.add(true);
            else ans.add(false);


        }

        return ans;


        
    }
}