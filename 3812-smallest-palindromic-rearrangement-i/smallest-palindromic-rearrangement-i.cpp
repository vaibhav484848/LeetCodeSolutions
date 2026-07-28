class Solution {
public:
    string smallestPalindrome(string s) {
        int n=s.size();

        sort(s.begin(),s.begin()+n/2);
        int start=0;
        for(int st=s.size()-1;st>=n/2;st--){
            s[st]=s[start];
            start++;
        }

        return s;
    }
};