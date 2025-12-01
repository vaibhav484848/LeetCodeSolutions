class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        reverse(word.begin(),word.end());

        int n=word.size();

        long long num=0;

        vector<int>ans;

        for(int i=n-1;i>=0;i--){
            int dig=word[i]-48;
            num=num*10+dig;
            num=num%m;
            if(num==0) ans.push_back(1);
            else ans.push_back(0);
        }

        return ans;
    }
};