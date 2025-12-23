class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        // sort(events.begin(),events.end());
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });


        int n=events.size();

        vector<vector<int>>dp(n,vector<int>(3,0));


        for(int i=0;i<n;i++){
            
            for(int take=1;take<3;take++){
                int ans=-1;
                if(take==1){
                    dp[i][take]=events[i][2];
                    if(i>0)dp[i][take]=max(dp[i][take],dp[i-1][take]);
                }
                else{
                    int st=events[i][0];
                    int lo=0,hi=i-1;

                    while(lo<=hi){
                        int mid=lo+(hi-lo)/2;

                        if(events[mid][1]<st){
                            ans=mid;
                            lo=mid+1;
                        }
                        else hi=mid-1;

                    } 
                    if(i>0){
                        if(ans!=-1){
                            dp[i][take]=events[i][2]+dp[ans][take-1];
                        }
                        dp[i][take]=max(dp[i][take],dp[i-1][take]);
                    }
                }
            }
        }

        return max(dp[n-1][1],dp[n-1][2]);
    }
};

/*

*/