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

        cout<<remO<<" this is remO\n";

        long long sum=0;

        int ans=INT_MAX;

        for(int i=0;i<n;i++){
            sum=sum+nums[i];

            int rem=sum%p;

            // cout<<rem<<" "<<i<<"\n";

            if(rem>remO){
                if(mp.find(rem-remO)!=mp.end() ){
                    int idx=mp[rem-remO];
                    ans=min(ans,i-idx);
                }
            }
            else if(rem<remO){
                // 2 we want 4  p=6. 8,4 curr - curr -(p-want )

                if(mp.find(rem+p-remO)!=mp.end()){
                    // cout<<"hello "<<i<<'\n';
                    int idx=mp[rem+p-remO];
                    ans=min(ans,i-idx);
                }
            }
            else{
                if(mp.find(0)!=mp.end()){
                    int idx=mp[0];
                    ans=min(ans,i-idx);
                }
                else
                {  
                    if(i+1!=n)
                    ans=min(ans,i+1);
                }
            }

            // if(mp.find(sum%p)==mp.end()){
                mp[(sum%p)]=i;
            // }

            
            // cout<<ans<<"\n";
            
        }

        return ans==INT_MAX?-1:ans;
    }
};