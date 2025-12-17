class Solution {
public:
    const int mod=1e9+7;
    int distinctSubseqII(string s) {
        int n=s.size();

        // int dp[2001];
        int pref[26]={0};

        long long preSum=0;

        for(int i=0;i<n;i++){
            char ch=s[i];
            int idx=ch-'a';

            int prevSum=preSum;
            

            preSum=(((preSum+preSum)%mod+1)%mod-pref[idx] + mod)%mod;
            pref[idx]=((pref[idx]+preSum)%mod-prevSum +mod)%mod;
        
            
        }

        return (int)preSum;


    }
};