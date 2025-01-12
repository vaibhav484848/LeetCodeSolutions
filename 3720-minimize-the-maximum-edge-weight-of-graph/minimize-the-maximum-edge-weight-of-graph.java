class Solution {
    boolean isPossible(int n,int[][] edges,int val){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
           int a=edges[i][0];
            int b=edges[i][1];
            int c=edges[i][2];

            if(c<=val){
                adj.get(b).add(a);
            }
        }

        int count=1;

        boolean[] visited=new boolean[n];

        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;

        while(q.size()>0){
            int p=q.remove();

            for(int ele:adj.get(p)){
                if(!visited[ele]){
                    q.add(ele);
                    count++;
                    visited[ele]=true;

                }
                
            }
        }
        return count==n;
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {

        int lo=Integer.MAX_VALUE;
        int hi=0;

        for(int i=0;i<edges.length;i++){
            int weight=edges[i][2];
            lo=Math.min(lo,weight);
            hi=Math.max(hi,weight);

        }

        System.out.println(lo+" "+hi);

        int ans=-1;



        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(isPossible(n,edges,mid)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }


        return ans;
        

        
    }
}