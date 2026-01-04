class Solution {
public:
    long long minimumCost(string s, string t, int flipCost, int swapCost, int crossCost) {

        long long len=s.size();
        long long count=0;
        long long count1s=0;

        for(int i=0;i<len;i++){
            if(s[i]!=t[i]){
                count++;
                if(s[i]=='1') count1s++;
            }
        }
        long long count1t=count-count1s;

        long long flip=flipCost*count;
        long long cost=0;


        long long minm=min(count1t,count1s);

        cost+=minm*swapCost;
        count-=(2*minm);

        long long times=count/2;

        int countT=count;

        long long cost1=times*(swapCost+crossCost);
        countT%=2;
        if(countT) cost1+=flipCost;

        long long cost2=count*flipCost;

        cost+=min(cost1,cost2);

        return min(cost,flip);





        
        return min(cost,flip);




        
    }
};