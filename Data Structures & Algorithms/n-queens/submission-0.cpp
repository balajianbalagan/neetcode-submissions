class Solution {
public:
    void rec(vector<vector<string>>& ans,vector<string> &cb,vector<pair<int,int>> qlocs,int n,int col){
        if(col==n){
            ans.push_back(cb);
            return;
        }

        for(int i=0;i<n;i++){
            if(canPlaceQueen(i,col,qlocs)){
                qlocs.push_back({i,col});
                cb[i][col] = 'Q';
                rec(ans,cb,qlocs,n,col+1);
                qlocs.pop_back();
                cb[i][col] = '.';
            }
        }
    }

    bool canPlaceQueen(int x,int y,vector<pair<int,int>> qlocs){
        for(int i=0;i<qlocs.size();i++){
            int qx = qlocs[i].first;
            int qy = qlocs[i].second;
            if(qx==x || qy==y || abs(qy-y)==abs(qx-x)){
                return false;
            }
        }
        return true;
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        string b(n,'.');
        vector<string> cb(n,b);
        vector<pair<int,int>> qlocs;
        rec(ans,cb,qlocs,n,0);
        return ans;
        
    }
};
