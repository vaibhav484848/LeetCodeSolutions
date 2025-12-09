class Solution {
public:
    int countTriples(int n) {

        map<int,int>mp;
        int count=0;

        for(int i=1;i<=n;i++){
            int b=i*i;
            for(int j=i+1;j<=n;j++){
                int c=j*j;

                int toFd=c-b;

                if(mp.find(toFd)!=mp.end())count+=2;



            }
            mp[b]++;
        }

        return count;
        
    }
};