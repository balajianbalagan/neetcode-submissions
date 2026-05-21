class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<unordered_map<char,int>> rows(9);
        vector<unordered_map<char,int>> cols(9);
        vector<unordered_map<char,int>> boxes(9);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char val = board[i][j];
                if(val == '.') continue;
                // Check row
                if(rows[i][val]++) return false;
                // Check column
                if(cols[j][val]++) return false;
                // Check box
                int boxindex = (i/3)*3 + (j/3);
                if(boxes[boxindex][val]++) return false;
            }
        }
        return true;
    }
};
