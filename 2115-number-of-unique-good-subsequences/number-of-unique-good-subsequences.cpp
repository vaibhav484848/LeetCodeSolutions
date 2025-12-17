class Solution {
public:
    const int mod=1e9+7;
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n=binary.size();

        long long preSum=0;
        int pref[2]={0};
        
        bool flagZero=false;


        for(int i=0;i<n;i++){
            char ch=binary[i];
            int idx=ch-'0';
            // cout<<idx<<'\n';

            int prevSum=preSum;

            
            int oneSub=oneSub=(preSum-flagZero + mod)%mod;

            preSum=(((preSum+oneSub)%mod + 1)%mod - pref[idx] + mod)%mod;
            pref[idx]=((pref[idx]+preSum)%mod - prevSum + mod)%mod;

            if(idx==0) flagZero=true;

            
        }
        return (int)preSum;
        
    }
};