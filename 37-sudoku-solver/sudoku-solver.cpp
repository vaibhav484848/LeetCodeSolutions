class Solution {
public:
    bool isValid(int i,int j,vector<vector<char>>& board,char ch){
        int iTimes=i/3;
        int jTimes=j/3;

        char val=board[i][j];
        val=ch;

        int stI=3*iTimes;
        int stJ=3*jTimes;

        for(int ii=stI;ii<stI+3;ii++){
            for(int jj=stJ;jj<stJ+3;jj++){
                if(ii==i && jj==j) continue;
                if(board[ii][jj]==val) return false;
            }
        }
        for(int y=0;y<board[0].size();y++){
            if(y==j) continue;
            if(board[i][y]==val) return false;
        }
        for(int x=0;x<board.size();x++){
            if(x==i) continue;
            if(board[x][j]==val) return false;
        }

        return true;
    }
    bool finalCheck(vector<vector<char>>& board){
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='.')return false;
            }
        }
        return true;
    }
    bool sudoChecker(vector<vector<char>>& board){
        
        bool ans=false;

        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='.') {
                    for(int k=1;k<10;k++){
                        char ch='0'+k;
                        if(isValid(i,j,board,ch)){
                            board[i][j]=ch;
                            ans|=sudoChecker(board);
                            if(!ans){
                                board[i][j]='.';
                            }
                            else{
                                return true;
                            }
                            
                        }
                    }
                    return false;
                }
                else{

                        continue;
                    
                }
            }
           
        }
        return true;
        
    }
    void solveSudoku(vector<vector<char>>& board) {
        sudoChecker(board);
    }
};