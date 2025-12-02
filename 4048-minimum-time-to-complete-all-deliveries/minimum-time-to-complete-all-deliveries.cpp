class Solution {
public:
    int lcm(int a,int b){
        return (a*b)/(__gcd(a,b));
    }
    bool check(long long mid,vector<int>& d,vector<int>& r){
        int d1=d[0];
        int d2=d[1];

        int r1=r[0];
        int r2=r[1];

        long long drone1= mid-mid/r1;
        long long drone2=mid - mid/r2 ;

        long long tot=1ll*d1+d2;
        long long lc=1ll*lcm(r1,r2);
        lc=mid-mid/lc;

        return (tot<=lc) && (d1<=drone1) && (d2<=drone2);

        // return (tot+lc)<= mid;


    }
    long long minimumTime(vector<int>& d, vector<int>& r) {
        long long lo=0,hi=1e15;

        long long ans=0;

        while(lo<=hi){
            long long mid=(lo+hi)/2;

            if(check(mid,d,r)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
};