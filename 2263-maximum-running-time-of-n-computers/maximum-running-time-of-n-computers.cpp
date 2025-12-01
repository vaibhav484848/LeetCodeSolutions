class Solution {
public: 

    int check(long long mid,int n, vector<int>& batteries){
        long long  sum=0,count=0;
        for(int i=batteries.size()-1;i>=0;i--){
            int ele=batteries[i];
            if(ele>=mid){
                count++;
                if(count==n) return 1;
            }
            else{
                sum+=ele;
                if(sum>=mid){
                    count++;
                    if(count==n) return 1;
                    sum=sum-mid;
                }
            }
        }
        return 0;
    }

    long long maxRunTime(int n, vector<int>& batteries) {
        // return 8;
        // sort(batteries.begin(),batteries.end());
        int minm=*min_element(batteries.begin(), batteries.end());

        if(n==batteries.size()) return minm;
        else{
            long long sum = accumulate(batteries.begin(), batteries.end(), 0LL);
            // return (sum/n);


            long long lo=1,hi=sum/n;
            long long ans=-1;

            while(lo<=hi){
                long long mid=(lo+(hi-lo)/2);

                if(check(mid,n,batteries)){
                    ans=mid;
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }

            return ans;
        }
    }
};