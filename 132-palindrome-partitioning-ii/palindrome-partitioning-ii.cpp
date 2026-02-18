class Solution {
public:
    vector<vector<int>>pDp;
    vector<int>dp;
    bool isPalindrome(int i,int j,string& str){
        if(i>=j) return true;

        if(pDp[i][j]!=-1) return pDp[i][j] ;

        return pDp[i][j]=(str[i]==str[j] && isPalindrome(i+1,j-1,str));
    }
    int rec(int idx,string& s){
        if(idx>=s.size()) return 0;

        if(dp[idx]!=-1) return dp[idx];
        int cost=1e9;
        for(int i=idx;i<s.size();i++){
            if(isPalindrome(idx,i,s)){
                cost=min(cost,1+rec(i+1,s) -((i==s.size()-1)?1:0));
            }
        }

        return dp[idx]=cost;
    }
    int minCut(string s) {
        pDp.assign(2001,vector<int>(2001,-1));
        dp.assign(2001,-1);


        return rec(0,s);

    
    }
};