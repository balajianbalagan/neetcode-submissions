class Solution {
public:
    bool rec(vector<vector<char>>& board, string& word,int ind,int row,int col){
        if(ind==word.size()){
            return true;
        }
        if(row>=board.size() || col>=board[0].size()){
            return false;
        }
        if(word[ind]!=board[row][col]){
            return false;
        }else{
            char temp = board[row][col];
            board[row][col]='#';
            bool ans =  rec(board,word,ind+1,row+1,col) || rec(board,word,ind+1,row,col+1) || rec(board,word,ind+1,row-1,col) || rec(board,word,ind+1,row,col-1);
            board[row][col] = temp;
            return ans;
        }


    }
    bool exist(vector<vector<char>>& board, string word) {
        int rows = board.size();
        int cols = board[0].size();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rec(board,word,0,i,j)){
                    return true;
                }
            }    
        }
        return false;
    }
};
