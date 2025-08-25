class Solution {
public:

//
// 0 14 14 14 16 16 16 
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        vector<pair<int,int>> events;

        int n=segments.size();
        for(int i=0;i<n;i++){
            int l=segments[i][0];
            int r=segments[i][1];
            int val=segments[i][2];
            events.push_back({l,val});
            events.push_back({r,-val});
        }

        sort(events.begin(),events.end());

        vector<vector<long long>> fans;

        long long  count=0;

        for(int i=0;i<events.size();i++){
            count+=events[i].second;
            // cout<<count<<endl;
            int firstS=events[i].first;

            if(i+1<events.size()){
                if(events[i+1].first!=firstS && count!=0){
                    fans.push_back({1l*firstS,1l*events[i+1].first,1l*count});
                }
                
            }
        }

        return fans;
    }
};


