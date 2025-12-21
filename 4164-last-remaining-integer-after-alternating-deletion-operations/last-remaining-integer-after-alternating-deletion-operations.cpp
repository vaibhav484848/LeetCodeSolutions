class Solution {
public:
    long long rec(long long st,long long end,long long r,long long nums,int l){
        long long tempSt=st;
        if(nums==2){
            return st;
        }
        if(nums%2==0){
            if(l)
            st=end-r/2;
            else st=end+r/2;
        }
        else{
            st=end;
        }
        end=tempSt;
        r*=2;
        nums=(nums+1)/2;
        return rec(st,end,r,nums,1-l);
    }
    long long lastInteger(long long n) {
        if(n==1)return 1LL;
        return rec(1,n,2,n,1);
    }
};