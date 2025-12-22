class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        map<int,int>mp;
        int maxVal=0,countMax=0;
        for(int i=0;i<tasks.size();i++){
            mp[tasks[i]-'A']++;
            maxVal=max(maxVal,mp[tasks[i]-'A']);
        }
        for(auto it=mp.begin();it!=mp.end();it++){
            if(it->second==maxVal) countMax++;
        }

        int ans=(maxVal-1)*n+maxVal+(countMax-1);
        return max((int)tasks.size(),ans);


        
    }
};