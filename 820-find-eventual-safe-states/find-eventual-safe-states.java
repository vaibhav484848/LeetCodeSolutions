class Solution {
    void bfs(int[] indegree,List<List<Integer>> li,List<Integer> ans){
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(q.size()>0){
            int temp=q.remove();
            ans.add(temp);

            for(int ele:li.get(temp)){
                if(indegree[ele]==1){
                    q.add(ele);
                }
                indegree[ele]--;
            }
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // reverse the graph

        List<List<Integer>> li= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            li.add(new ArrayList<>());
        }
        int[] indegree= new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int ele:graph[i]){
                li.get(ele).add(i);
                indegree[i]++;
            }
        }
        List<Integer> ans= new ArrayList<>();
        
        bfs(indegree,li,ans);
        Collections.sort(ans);
        return ans;
        
        
    }
}