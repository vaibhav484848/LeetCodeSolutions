class Solution {
public:
    int smallestRepunitDivByK(int k) {
        if(k%2==0) return -1;
        int num=1;

        int times=0;

        while(times<k){
            times++;
            if(num%k==0){
                return times;
            }
            num=num%k;
            num=num*10+1;
        }

        return -1;

    }
};

//1*10+1
//(curr*10+1)%k