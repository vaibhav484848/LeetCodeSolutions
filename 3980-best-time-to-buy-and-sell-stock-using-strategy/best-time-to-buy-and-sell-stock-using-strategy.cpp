class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        #define int long long
        int inProfit=0;

        int n=prices.size();

        vector<int> prefix;

        prefix.push_back(prices[0]*strategy[0]);
        inProfit+=prices[0]*strategy[0];

        for(int i=1;i<n;i++){
            int pro=prices[i]*strategy[i];
            inProfit+=pro;
            prefix.push_back(pro+prefix[i-1]);
        }

        // cout<<inProfit<<endl;
        int mPro=LONG_MIN;
        mPro=max(mPro,inProfit);

        int half=k/2;

        int i=0;
        int j=k/2;

        int sum=0;

        while(j<n){
            sum+=prices[j];
            if(j-i+1==k){
                int add=prefix[n-1]-prefix[j];
                // cout<<add<<" add\n";
                sum+=(prefix[n-1]-prefix[j]);
                
                mPro=max(mPro,sum);
                
                // cout<<prices[i]<<" i \n";
                sum-=prices[j-half+1];
                sum-=add;
                // cout<<prices[j-half+1]<<" jtoremove: ";
                sum+=prices[i]*strategy[i];
                // cout<<prefix[i]<<"i to add\n";
                i++;
                
            }
            j++;
            
            // su
            // sum+=prices[i];
            // if(j-i+1==k){
            //     sum-=prefix[i];
            //     i++;
            // }
            // mPro=max(mPro,sum);
            // j++;
        }

        return mPro;

        #undef int 
    }
};