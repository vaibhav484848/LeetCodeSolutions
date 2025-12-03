class Solution {
public:
    long long lcm(int a,int b){
        return (1ll*a*b)/__gcd(a,b);
    }
    bool check(int mid,int div1,int div2,int u1,int u2){

        int nums1=mid-mid/div1;
        int nums2=mid- mid/div2;

        long long com= mid/(lcm(div1,div2));

        return  nums1>=u1 && nums2>=u2  && (mid-com) >=(u1+u2);
    }
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int lo=1,hi=INT_MAX,ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(check(mid,divisor1,divisor2,uniqueCnt1,uniqueCnt2)){
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