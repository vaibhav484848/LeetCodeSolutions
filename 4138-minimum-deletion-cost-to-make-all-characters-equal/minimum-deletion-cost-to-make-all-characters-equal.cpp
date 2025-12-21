class Solution {
public:
    long long minCost(string s, vector<int>& cost) {

        long long ans=1e18;
        
        for(int i=0;i<26;i++){
            char ch='a'+i;
            
            long long sum=0;

            for(int j=0;j<s.size();j++){
                char str=s[j];

                if(str!=ch){
                    sum+=cost[j];
                }
            }
            ans=min(ans,sum);
        }
        return ans;
    }
};