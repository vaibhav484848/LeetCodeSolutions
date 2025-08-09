class Solution {
public:
    const int MOD=1e9+7;
    int check(int n,long long mid,int a,int b){

        long long total=0;

        // total=(total+(mid/a)%MOD)%MOD;
        // total=(total+(mid/a)%MOD)%MOD;

        int lc=(a*b)/(__gcd(a,b));


        total+=(mid/a);
        total+=(mid/b);
        total-=(mid/lc);

        return total>=n;

    }
    int nthMagicalNumber(int n, int a, int b) {
        long long lo=2;
        long long hi=1e18;

        long long ans=0;

        while(lo<=hi){
            long long mid=lo+(hi-lo)/2;

            if(check(n,mid,a,b)==0){
                lo=mid+1;
            }
            else{
                ans=(mid%MOD);
                hi=mid-1;

            }
        }

        return ans;
    }
};