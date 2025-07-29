class Solution {
public:     
    vector<vector<string>> fans;
    vector<int> ans;

    void addFans(int n){
        // vector<vector<char>> v(n,vector<char>(n,'.'));
        vector<string> v1;
        for(int i=0;i<n;i++){
            int col=ans[i];
            string s="";
            for(int j=0;j<n;j++){
                if(j==col){
                    s.push_back('Q');
                    // v[i][j]='Q';
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

        int c=col;
        //vertical
        for(int i=level-1;i>=0;i--){
            if(ans[i]==col) return false;
        }
        //leftDiagonal

        for(int i=level-1;i>=0;i--){
            if(ans[i]==c-1) return false;
            c--;
        }

        c=col;
        //rightDiagonal
        for(int i=level-1;i>=0;i--){
            if(ans[i]==c+1) return false;
            c++;
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