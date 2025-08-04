class Solution {
public:
    
    int check(long long mid,int k,vector<int> time)
    {
        long long trip=0;
        for(int i=0;i<time.size();i++){
            trip+=1ll*(mid/time[i]);
            if(trip>=k) return 1;
        }
        return 0;
    }
    long long minimumTime(vector<int>& time, int totalTrips) {
        // #define int long long
        long long lo=1;
        long long hi=1e18;

        long long ans=0;

        while(lo<=hi){
            long long mid=(lo+(hi-lo)/2);

            if(check(mid,totalTrips,time)==0){
                lo=mid+1;
            }
            else{
                ans=mid;
                hi=mid-1;
            }
        }

        return ans;


        // #undef int
    }
};