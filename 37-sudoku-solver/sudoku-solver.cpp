class Solution {
public:

    vector<vector<char>> ans;

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
    
   
    void sudoChecker(vector<vector<char>>& board,int ii,int jj){

        if(jj==board[0].size()){
            ii++;
            jj=0;
        }
        if(ii==board.size()){
            ans=board;
            return;
        }
        
        if(board[ii][jj]=='.') {
            for(int k=1;k<10;k++){
                char ch='0'+k;
                if(isValid(ii,jj,board,ch)){
                    board[ii][jj]=ch;
                    sudoChecker(board,ii,jj+1);   
                    board[ii][jj]='.';         
                }
            }
        }
        else{
            sudoChecker(board,ii,jj+1);
        }
                    
    
        
    }
    void solveSudoku(vector<vector<char>>& board) {

        sudoChecker(board,0,0);

        board=ans;
    }
};