class Solution {
public:     
    vector<vector<string>> fans;
    vector<int> ans;

    void addFans(int n){
        
        vector<string> v1;
        for(int i=0;i<n;i++){
            int col=ans[i];
            string s="";
            for(int j=0;j<n;j++){
                if(j==col){
                    s.push_back('Q');
                    
                }
                else{
                    s.push_back('.');
                }
            }
            v1.push_back(s);
        }
        
        // f
        fans.push_back(v1);
    }

    bool isValid(int level,int col){


        for(int prow=0;prow<level;prow++){
            if(ans[prow]==col || abs(prow-level)==abs(ans[prow]-col))return false;
        }
        
        return true;


    }

    void rec(int level,int n){
        if(level==n){
            addFans(n);
            return;
        }
        
        
        for(int col=0;col<n;col++){
            if(isValid(level,col)){
                ans.push_back(col);
                rec(level+1,n);
                ans.pop_back();
            }
        }

    }
    vector<vector<string>> solveNQueens(int n) {
        rec(0,n);
        return fans;
        
    }
};