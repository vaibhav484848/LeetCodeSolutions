class Solution {
public:
    int mod=1e9+7;
    int nc2(int val){
        long long ans=(1ll*val*(val-1))%mod;
        ans=ans/2;
        return (int)(ans);
    }
    int countTrapezoids(vector<vector<int>>& points) {
        int n=points.size();

        map<int,int>mp;

        for(int i=0;i<n;i++){
            int y=points[i][1];
            mp[y]++;
        }
        vector<int>pre(mp.size(),0);
        int i=0;
        for(auto it:mp){
            pre[i]=nc2(it.second)+ ((i>0)?pre[i-1]:0);
            i++;
        }

        

        int idx=0;
        long long ans=0;
        for(auto it:mp){
            
            int after=0;
            
            if(idx<pre.size()-1){
                after=pre[pre.size()-1]-pre[idx];
            }

            long long total=(after)%mod;

            long long comb=nc2(it.second);

            long long curr=(comb*total)%mod;

            ans=(ans+curr)%mod;




            idx++;
        }

        return (int)(ans);
    }
};



// 2,3,4,8;