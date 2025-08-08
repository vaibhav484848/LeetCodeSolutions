class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int n=seats.size();
        int pre[n];
        int suff[n];

        int last1=1e5;

        for(int i=0;i<n;i++){
            if(seats[i]==1) {
                last1=i;
            }
            else{
                if(last1==1e5)pre[i]=last1;
                else
                pre[i]=i-last1;
            }
        }
        last1=1e5;
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1) {
                last1=i;
                
            }
            else{
                suff[i]=last1-i;
            }
        }

        int maxm=INT_MIN;
        for(int i=0;i<n;i++){
            if(seats[i]==0){
                int left=pre[i];
                int right=suff[i];

                cout<<left<<right<<endl;

                if(left==1e5){
                    maxm=max(maxm,right);
                }
                else if(right==1e5){
                    maxm=max(maxm,left);
                }
                else{
                    maxm=max(maxm,min(left,right));
                }
            }
            

        }

        return maxm;


        
    }
};