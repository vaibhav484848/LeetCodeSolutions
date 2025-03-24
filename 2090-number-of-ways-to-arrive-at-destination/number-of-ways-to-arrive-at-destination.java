class Solution {
    int mod=1000000007;
    class Pair{
        int node;
        long weight;

        Pair(int node,long weight){
            this.node=node;
            this.weight=weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int rL=roads.length;

        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<rL;i++){
            int a=roads[i][0];
            int b=roads[i][1];
            int c=roads[i][2];

            adj.get(a).add(new Pair(b,c));
            adj.get(b).add(new Pair(a,c));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            // return a.weight-b.weight;
            return Long.compare(a.weight,b.weight);
        });

        // boolean[] visited=new boolean[n];
        long[] distance=new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[0]=0L;

        pq.add(new Pair(0,0L));
        // visited[0]=true;

        int count=0;

        long[] ways=new long[n];
        ways[0]=1;

        while(pq.size()>0){
            Pair p=pq.remove();
            int node=p.node;
            long weight=p.weight;

            if(weight>distance[node]) continue;

            for(Pair temp:adj.get(node)){
                int newNode=temp.node;
                long newWeight=temp.weight;

                long totalWeight=(long)(weight+newWeight);
                
                // if(newNode==n-1){
                //     if(totalWeight==distance[n-1]) count++;
                //     else if(totalWeight<distance[n-1]){
                //          count=1;
                //          distance[n-1]=totalWeight;
                //     }
                // }
                
                if(totalWeight<distance[newNode]){
                    ways[newNode]=ways[node];
                    pq.add(new Pair(newNode,totalWeight));
                    distance[newNode]=totalWeight;
                }
                else if(totalWeight==distance[newNode]) ways[newNode]= (ways[newNode]%mod+ways[node]%mod)%mod;
                
            }
        }
        
        return (int)ways[n-1]%mod;
        
    }
}