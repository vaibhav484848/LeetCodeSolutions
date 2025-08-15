class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {

        int n=values.size();

        vector<int> prefix(n,0);
        prefix.push_back(values[0]);
        prefix[0] =INT_MIN;

        for(int i=1;i<n;i++){
            prefix[i]=max(values[i-1]+(i-1),prefix[i-1]);
        }

        vector<int> suffix(n,0);
        suffix[n-1] = values[n-1]-(n-1);

        for(int i=n-2;i>=0;i--){
            suffix[i]=max(suffix[i+1],values[i]-i);
        }

        int ans=0;

        for(int i=0;i<n;i++){
            ans=max(ans,prefix[i]+suffix[i]);
        }

        return ans;



    }
};