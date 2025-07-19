class Solution {
    int minm=0;

    int dfs(int node,List<List<Integer>> adj,int[] cost,boolean[] visited){
        visited[node]=true;
        boolean flag=false;
        int maxm=Integer.MIN_VALUE;
        int counter=0;
        // Set<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:adj.get(node)){
            if(!visited[ele]){
                int co=dfs(ele,adj,cost,visited);
                
                if(co>=maxm){
                    maxm=Math.max(maxm,co);
                    map.put(maxm,map.getOrDefault(maxm,0)+1);
                }
                
                // set.add(co);
                counter++;

                
                flag=true;
            }
        }
        // System.out.println("set: "+set);
        // System.out.println("minm : "+minm);

        if(flag){
            // minm+=(set.size()-1);
            minm+=(counter-map.get(maxm));
        }
        if(!flag){
            return cost[node];
        }
        return cost[node]+maxm;
    }
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] arr:edges){
            int a=arr[0];
            int b=arr[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        // System.out.println(adj);
        boolean [] visited=new boolean[n];
        dfs(0,adj,cost,visited);
        return minm;


        
    }
}