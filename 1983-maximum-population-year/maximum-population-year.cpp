class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        vector<int> v(101);

        for(auto log:logs){
            int a=log[0];
            int b=log[1];

            v[a-1950]++;
            v[b-1950]--;
        }

        int maxAns=v[0];
        int maxYear=1950;

        for(int i=1;i<v.size();i++){
            v[i]+=v[i-1];
            if(maxAns<v[i]){
                maxAns=v[i];
                maxYear=i+1950;
            }
        }

        return maxYear;
        
    }
};