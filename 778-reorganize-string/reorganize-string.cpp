class Solution {
public:
    string reorganizeString(string s) {
        int n=s.size();

        vector<char>ans(n,'.');

        multiset<pair<int,int>>m;
        map<char,int>mp;

        for(int i=0;i<n;i++){
            char ch=s[i];
            mp[ch]++;
        }
        for(auto it=mp.begin();it!=mp.end();it++){
            m.insert({it->second,it->first});
        }

        auto maxm=m.rbegin();
        if(maxm->first>(n+1)/2) return "";

        
            int idx=0;
        
            
            while(m.size() >0){
                auto it=m.rbegin();
                int times=m.rbegin()->first;
                char ch=m.rbegin()->second;
                
                while(times>0 ){
                    if(idx>=n)idx=1;
                    ans[idx]=ch;
                    times--;
                    idx+=2;
                }
                auto rit = it;              
                auto itt = next(rit).base();         
                m.erase(itt);  
                mp.erase(ch);
                if(times>0){
                    m.insert({times,ch});
                    mp[ch]=times;
                }
            }  

            
            string str="";
            for(int i=0;i<ans.size();i++){
                str+=ans[i];
            }

            return str;
        
    }
};