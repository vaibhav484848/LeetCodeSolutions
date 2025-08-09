class Solution {
public:
    int mySqrt(int x) {

        // #define int long long

        int lo=1;
        int hi=x;

        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(1l*mid*mid<=1l*x){
                ans=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        return ans;

        // #undef int 
    }
};