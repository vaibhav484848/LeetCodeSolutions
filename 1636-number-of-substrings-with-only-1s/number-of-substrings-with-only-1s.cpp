class Solution {
public:
    int numSub(string s) {
        int n=s.size();

        int mod=1e9+7;

        long long i=0,j=0,count=0;

        while(j<n){
            if(s[j]=='0'){
                i=j+1;
                j++;
                continue;
            }
            count=(count+(j-i+1))%mod;
            j++;
        }
        return (int) count;
    }
};