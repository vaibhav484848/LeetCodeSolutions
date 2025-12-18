class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        #define int long long
        int n=strategy.size();

        int score=0;

        vector<int>pre(n,0);
        pre[0]=prices[0] *strategy[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+prices[i] *strategy[i];
        }
        for(int i=0;i<k;i++){
            if(i>=(k/2)){
                score+=prices[i];
            }
        }
        
        int total=pre[n-1];

        int maxm=total;

        maxm=max(maxm,score+total-pre[k-1]);
        for(int i=k;i<n;i++){
            score+=prices[i];
            score-=(prices[i-(k/2)]);
            
            score+=(pre[i-k]-((i-k>0)?pre[i-k-1]:0));
            
            maxm=max(maxm,score+total-pre[i]);
        }

        return maxm;

        #undef int
    }
};