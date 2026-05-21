class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // rows[i][d]: whether digit d has been seen in row i
        // cols[j][d]: whether digit d has been seen in column j
        // boxes[b][d]: whether digit d has been seen in box b
        bool rows[9][9] = {}, cols[9][9] = {}, boxes[9][9] = {};

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                char val = board[i][j];
                if(val == '.') continue;
                int d = val - '1'; // digit index 0-8
                int box = (i / 3) * 3 + (j / 3);
                if(rows[i][d] || cols[j][d] || boxes[box][d])
                    return false;
                rows[i][d] = cols[j][d] = boxes[box][d] = true;
            }
        }
        return true;
    }
};
