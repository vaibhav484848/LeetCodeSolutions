class Solution {
public:

    
    vector<int> ans;
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

    int rec(int level,int n){
        if(level==n){
            // addFans(n);
            return 1;
        }
        int fans=0;
        
        
        for(int col=0;col<n;col++){
            if(isValid(level,col)){
                ans.push_back(col);
                fans+=rec(level+1,n);
                ans.pop_back();
            }
        }
        return fans;

    }
    int totalNQueens(int n) {
        return rec(0,n);
    }
};