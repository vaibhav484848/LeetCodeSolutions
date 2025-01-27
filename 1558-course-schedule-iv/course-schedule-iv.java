class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];

            adj.get(a).add(b);
            indegree[b]++;
        }

        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                 q.add(i);
                 map.put(i,new HashSet<>());
            }
        }


        while(q.size()>0){
            int node=q.remove();
            
            for(int ele:adj.get(node) ){
                if(indegree[ele]==1){
                    q.add(ele);
                }
                
                HashSet<Integer> set=map.get(node);
                HashSet<Integer> newSet=map.getOrDefault(ele,new HashSet<>());

                

                newSet.add(node);

                for(int temp:set){
                    newSet.add(temp);
                }
                map.put(ele,newSet);
                indegree[ele]--;
            }
        }

        
        List<Boolean> fans=new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];

           if(map.get(b).contains(a)) fans.add(true);
           else fans.add(false);



            
        }
        return fans;

        
        
    }
}