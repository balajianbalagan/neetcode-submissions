class Solution {
public:
    void genRec(int open, int close, int n, string par, vector<string>& ans) {
        if (par.size() == 2 * n) {
            ans.push_back(par);
            return;
        }
        
        if (open < n) {
            genRec(open + 1, close, n, par + '(', ans);
        }
        if (close < open) {
            genRec(open, close + 1, n, par + ')', ans);
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        genRec(0, 0, n, "", ans);
        return ans;
    }
};
