class Solution {
public:
    int rec(int st,int end,int nums,int r,int l){

        int tempSt=st;

        if(st==end) return st;

        if(nums&1){
            if(l)
            st=end-r/2;
            else st=end+r/2;
        }
        else st=end;

        if(l)
        end=tempSt+r/2;
        else end=tempSt-r/2;

        r*=2;

        nums=(nums)/2;

        return rec(st,end,nums,r,1-l);

    }
    int lastRemaining(int n) {
        return rec(1,n,n,2,1);
    }
};