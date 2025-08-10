class Solution {
public:
    bool check(string n){
        if(n.size()>0 && n[0]=='0') return false;
        int num=stoi(n);
        // cout<<num<<" num\n";
        return (num&(num-1))==0;
    }
    bool reorderedPowerOf2(int n) {
        string s=to_string(n);
        sort(s.begin(),s.end());

        do{
            if(check(s)) return true;
            // cout<<s<<endl;
        }while(next_permutation(s.begin(),s.end()));

        return false;
    }
};