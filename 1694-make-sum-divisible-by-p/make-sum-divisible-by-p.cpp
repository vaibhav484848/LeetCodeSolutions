class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        map<int,int>mp;

        int n=nums.size();
        long long tSum=0;

        for(int ele:nums){
            tSum+=ele;
        }
        if(tSum%p==0) return 0;
        int remO=(tSum%p);


        long long sum=0;

        int ans=n;

        mp[0]=-1;

        for(int i=0;i<n;i++){
            sum=sum+nums[i];

            int rem=sum%p;

            int toFd=(rem-remO+p)%p;
            
            if(mp.find(toFd)!=mp.end()){
                ans=min(ans,i-mp[toFd]);
            }
            
            mp[rem]=i;

        
            
        }

        return ans==n?-1:ans;
    }
};