class Solution {
public:

    #define F first
    #define S second

    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {

        vector<vector<pair<int,int>>>adj;
        adj.resize(n+1);

        for(int i=0;i<flights.size();i++){
            int a=flights[i][0];
            int b=flights[i][1];
            int c=flights[i][2];

            adj[a].push_back({b,c});
        }

        vector<vector<int>>dist(k+2,vector<int>(n+1,1e9));
        vector<vector<int>>visited(k+2,vector<int>(n+1,0));


        dist[0][src]=0;
            

        priority_queue<pair<pair<int,int>,int>> pq;

        pq.push({{0,0},src});

        while(pq.size()>0){
            auto curr=pq.top();
            pq.pop();

            // int distance=-curr.F.F;
            int stops=curr.F.S;
            int node=curr.S;

            if(visited[stops][node])continue;
            visited[stops][node]=1;

            if(stops==k+1) continue;


            for(auto temp:adj[node]){
                int newNode=temp.F;
                int weight=temp.S;

                

                if(dist[stops+1][newNode]>dist[stops][node]+weight){
                    dist[stops+1][newNode]=dist[stops][node]+weight;
                    pq.push({{-dist[stops+1][newNode],stops+1},newNode});
                }
            }
        }

        int minm=1e9;

        for(int i=0;i<=k+1;i++){
            minm=min(minm,dist[i][dst]);
        }

        if(minm==1e9) return -1;

        return minm;
        
    }
};