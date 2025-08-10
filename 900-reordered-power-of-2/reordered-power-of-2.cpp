class Solution {
public:
    
    bool reorderedPowerOf2(int n) {
        int i=0,num=0;

        unordered_set<string> set;

        while(i<=31){
            num=(1<<i);
            string str=to_string(num);
            sort(str.begin(),str.end());
            set.insert(str);
            i++;
        }

        
        string s=to_string(n);
        sort(s.begin(),s.end());

        if(set.find(s)!=set.end()){
            return true;
        }
        return false;
    }
};