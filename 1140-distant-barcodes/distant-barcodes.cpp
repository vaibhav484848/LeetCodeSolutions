class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        map<int,int>mp;
        int n=barcodes.size();

        

        for(int i=0;i<n;i++){
            mp[barcodes[i]]++;
        }
        multiset<pair<int,int>>m;
        for(auto it=mp.begin();it!=mp.end();it++){
            m.insert({it->second,it->first});
        }

        int idx=0;
        vector<int>ans(n);

        while(m.size()>0){
            auto it=m.rbegin();
            int times=it->first;
            int num=it->second;

            while(times--){
                if(idx>=n) idx=1;
                ans[idx]=num;
                idx+=2;
            }
            m.erase(next(it).base());
        }

        return ans;
    }
};