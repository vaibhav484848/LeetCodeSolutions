class Solution {
public:
    
    #define F first
    #define S second

    int mod=1e9+7;

    int countPaths(int n, vector<vector<int>>& roads) {
        #define int long long

        using state=pair<int,int>;

        vector<vector<state>>adj;
        adj.resize(n+1);

        for(int i=0;i<roads.size();i++){
            int a=roads[i][0];
            int b=roads[i][1];
            int weight=roads[i][2];

            adj[a].push_back({b,weight});
            adj[b].push_back({a,weight});
        }

        vector<int>dist(n+1,1e18);
        vector<int>ways(n+1,0);
        vector<int>visited(n+1,0);

        ways[0]=1;
        dist[0]=0;

        priority_queue<state>pq;
        pq.push({0,0});

        while(pq.size()>0){
            state curr=pq.top();
            int dis=-curr.F;
            int node=curr.S;
            pq.pop();

            if(visited[node])continue;
            visited[node]=1;

            for(auto neigh:adj[node]){
                int newNode=neigh.F;
                int cost=neigh.S;

                if(dist[newNode]>dist[node]+cost){
                    dist[newNode]=dist[node]+cost;
                    pq.push({-dist[newNode],newNode});
                    ways[newNode]=(ways[node])%mod;
                }
                else if(dist[newNode]==dist[node]+cost){
                    ways[newNode]=(ways[newNode]+ways[node])%mod;
                }

            }
        }

        
        #undef int
        return ways[n-1];
        
        
    }
};