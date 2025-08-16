class Solution {
public:
    bool check(map<char,int>mp1,map<char,int>mp2){
        for(auto it:mp1){
            int key=it.first;
            int val=it.second;
            if(val==0) continue;

            if(mp2.find(key)!=mp2.end()){
                if(mp2[key]<mp1[key]) return false;
            }
            else
            return false;
        }
        return true;
    }
    int balancedString(string s) {
        map<char,int> mp;

        int n=s.size();

        for(int i=0;i<n;i++){
            mp[s[i]]++;
        }
        for(auto it:mp){
            // cout<<it.first<<" "<<it.second<<endl;
            if((it.second)>n/4){
                mp[it.first]-=(n/4);
            }
            else 
            mp[it.first]=0;
            
        }

        // for(auto it:mp){
        //     cout<<it.first<<" "<<it.second<<endl;
            
            
        // }
        

        

        map<char,int> mp2;

        if(check(mp,mp2)) return 0;

        // cout<<"hello"<<endl;

        int i=0,j=0;
        int minLen=INT_MAX;

        while(j<n){
            mp2[s[j]]++;

            while(check(mp,mp2)){
                minLen=min(minLen,j-i+1);
                mp2[s[i]]--;
                i++;
            }
            j++;

        }

        return minLen;

    }
};