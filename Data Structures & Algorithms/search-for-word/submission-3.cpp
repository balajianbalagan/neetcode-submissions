class Solution {
public:
    bool rec(vector<vector<char>>& board, string& word,int ind,int row,int col,vector<vector<int>> used){
        if(ind==word.size()){
            return true;
        }
        if(row>=board.size() || col>=board[0].size() || used[row][col]==1){
            return false;
        }
        if(word[ind]!=board[row][col]){
            return false;
        }else{
            used[row][col]=1;
            return rec(board,word,ind+1,row+1,col,used) || rec(board,word,ind+1,row,col+1,used) || rec(board,word,ind+1,row-1,col,used) || rec(board,word,ind+1,row,col-1,used);
        }


    }
    bool exist(vector<vector<char>>& board, string word) {
        int rows = board.size();
        int cols = board[0].size();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                    vector<vector<int>> used(rows,vector<int>(cols,0));
                // if(board[i][j]==word[0]){
                    int result = rec(board,word,0,i,j,used); 
                    if(result)return true;
                // }
            }    
        }
        return false;
    }
};
