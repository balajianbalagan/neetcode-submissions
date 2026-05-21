class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        vector<unordered_map<char,int>> rows(9);
        vector<unordered_map<char,int>> cols(9);
        vector<unordered_map<char,int>> boxes(9);
        for(int i=0;i<9;i++){
            unordered_map<char,int> colmp;
            unordered_map<char,int> rowmp;
            for(int j=0;j<9;j++){
                
                rowmp[board[i][j]]++;
                colmp[board[j][i]]++;

                int boxrowindex = i/3;
                int boxcolindex = j/3;
                int boxindex = 3*boxrowindex + boxcolindex;
                boxes[boxindex][board[i][j]]++;
                
            }
            rows[i] = rowmp;
            cols[i] = colmp;
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                // same row and col should be 1
                // other rows and cols in the block should be 0
                // find which block is it
                char val = board[i][j];
                if(val=='.')continue;
                int boxrowindex = i/3;
                int boxcolindex = j/3;
                int boxindex = 3*boxrowindex + boxcolindex;
                // cout<<rows[i][val]<<" "<<cols[i][val]<<" "<<boxes[boxindex][val]<<endl;
                if(rows[i][val]>1 || cols[i][val]>1 || boxes[boxindex][val]>1){
                    return false;
                }
            }
        }

        return true;

    }
};
