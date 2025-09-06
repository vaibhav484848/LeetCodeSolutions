class Solution {
public:

    using event=pair<pair<int,int>,int>;

    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {

        multiset<int> set;

        vector<event> events;

        for(auto v:buildings){

            int a=v[0];
            int b=v[1];
            int c=v[2];

            events.push_back({{a,1},c});
            events.push_back({{b,2},c});

        }
        // sort(events.begin(),events.end());
        sort(events.begin(), events.end(), [](const event &a, const event &b) {
            if (a.first.first != b.first.first)
                return a.first.first < b.first.first; // sort by x ascending
            
            if (a.first.second == 1 && b.first.second == 1)
                return a.second > b.second; 
            
            if (a.first.second == 2 && b.first.second == 2)
                return a.second < b.second; 
            
            return a.first.second < b.first.second;
        });


        vector<vector<int>> ans;

        int prev=0;

        int count=1;

        for(event e:events){

            int type=e.first.second;


            if(type==1){
                set.insert(e.second);

                int maxVal=*(set.rbegin());

                if(prev!=maxVal){
                    prev=maxVal;
                    ans.push_back({e.first.first,prev});
                }
            }
            else{
                set.erase(set.find(e.second));
                
                int maxVal=(set.size()>0)?*(set.rbegin()):0;

                if(prev!=maxVal){
                    prev=maxVal;
                    ans.push_back({e.first.first,prev});
                }

            }

            


        }


        return ans;
    }
};