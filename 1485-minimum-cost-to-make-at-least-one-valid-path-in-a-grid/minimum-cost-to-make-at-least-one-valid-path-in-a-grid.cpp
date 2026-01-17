class Solution {
public:
    using state=pair<int,int>;
    
    #define F first
    #define S second
    
    

    int dx[4]={0,0,1,-1};
    int dy[4]={1,-1,0,0};

    int minCost(vector<vector<int>>& grid) {

        int m=grid.size();
        int n=grid[0].size();


        vector<vector<int>>dist;
        dist.resize(m,vector<int>(n,1e9));

        deque<state>dq;
        dq.push_back({0,0});
        dist[0][0]=0;


        while(dq.size()>0){
            state curr=dq.front();

            int x=curr.F;
            int y=curr.S;
            int sign=grid[x][y];

            dq.pop_front();

            auto isValid=[m,n](int x,int y){
                if(x>=m || y>=n || x<0 || y<0) return false;
                return true;
            };

            for(int i=0;i<4;i++){
                int x_new=x+dx[i];
                int y_new=y+dy[i];

                

                if(isValid(x_new,y_new)){
                    int cost=1;
                    if(sign-1==i)cost=0;
                    if(dist[x_new][y_new]>dist[x][y]+cost){
                        dist[x_new][y_new]=cost+dist[x][y];
                        if(cost==0){
                            dq.push_front({x_new,y_new});
                        }
                        else{
                            dq.push_back({x_new,y_new});
                        }
                    }
                    
                }
                
            }
        }

        return dist[m-1][n-1];


        
    }
};