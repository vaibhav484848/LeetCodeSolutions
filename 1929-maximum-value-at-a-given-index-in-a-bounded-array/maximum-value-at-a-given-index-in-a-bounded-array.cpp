class Solution {
public:
    bool check(int mid,int sum,int n,int idx){

        long long acc=0;

        int right=n-(idx+1);
        int left=idx;

        // cout<<right<<" "<<left<<'\n';

        long long toAddR=1ll*mid*(mid+1)/2;

        long long toAddL=1ll*mid*(mid-1)/2;
        
        acc+=toAddL;
        acc+=toAddR;

        if(left<mid){
            int diff=(mid-1)-left;
            acc-=(1ll*diff)*(diff+1)/2;
        }
        else{
            left-=(mid-1);
            acc+=left;
        }

        if(right>=mid){
            
            right-=(mid-1);
            acc+=right;
        }
        else{
            int diff=(mid-1)-right;
            acc-=(1ll*diff)*(diff+1)/2;
        }

        return acc<=sum;
    }
    int maxValue(int n, int index, int maxSum) {
        int lo=1,hi=maxSum,ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(check(mid,maxSum,n,index)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }

        return ans;
    }
};