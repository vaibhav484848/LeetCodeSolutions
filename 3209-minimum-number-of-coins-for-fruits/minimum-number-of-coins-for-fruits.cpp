class Solution {
public:
    int dp[1005];

    int rec(int idx,vector<int>& prices){
        if(idx>=prices.size()){
            return 0;
        }
        if( dp[idx]!=-1){
            return dp[idx];
        }
        int currIdx=idx+1;

        int a=1e9;

        for(int i=idx+1;i<=2*currIdx;i++){
            a= min(a,prices[idx]+ rec(i,prices));
        }

        return dp[idx]=a;
    }
    int minimumCoins(vector<int>& prices) {

        int n=prices.size();

        for(int i=0;i<=n;i++){
            
                dp[i]=-1;
            
        }

        return rec(0,prices);

        
    }
};