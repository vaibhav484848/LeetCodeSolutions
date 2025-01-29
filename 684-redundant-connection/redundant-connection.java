class Solution {
    int find(int i,int [] parent){
        if(i==parent[i]) return i;

        return parent[i]=find(parent[i],parent);
    }

    boolean union(int a,int b,int [] parent,int[] rank){
        int a_parent=find(a,parent);
        int b_parent=find(b,parent);

        if(a_parent==b_parent) return false;

        if(rank[a_parent]>rank[b_parent]){
            parent[b_parent]=parent[a_parent];
        }
        else if(rank[b_parent]>rank[a_parent]){
            parent[a_parent]=parent[b_parent];
        }
        else{
            parent[b_parent]=parent[a_parent];
            rank[a_parent]++;
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] parent=new int[1001];
        int[] rank=new int[1001];

        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];

            if(!union(a,b,parent,rank)){
                return new int[]{a,b};
            }
        }
        return new int[]{-1,-1};



        
    }
}