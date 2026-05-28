class Solution {
public:
    void rec(vector<vector<string>>& ans,vector<string> &cb,vector<int> &rowmap,vector<int> &colmap,vector<int> &diagmap,vector<int> &antidiagmap,int n,int col){
        if(col==n){
            ans.push_back(cb);
            return;
        }

        for(int i=0;i<n;i++){
            if(canPlaceQueen(i,col,rowmap,colmap,diagmap,antidiagmap,n)){
                // qlocs.push_back({i,col});
                rowmap[i]=1;
                colmap[col]=1;
                diagmap[n-1+i-col]=1;
                antidiagmap[i+col]=1;
                cb[i][col] = 'Q';
                rec(ans,cb,rowmap,colmap,diagmap,antidiagmap,n,col+1);
                // qlocs.pop_back();
                colmap[col]=0;
                rowmap[i]=0;
                diagmap[n-1+i-col]=0;
                antidiagmap[i+col]=0;
                cb[i][col] = '.';
            }
        }
    }

    bool canPlaceQueen(int x,int y,vector<int> &rowmap,vector<int> &colmap,vector<int> &diagmap,vector<int> &antidiagmap,int n){
        if(rowmap[x]==1 || colmap[y]==1 || diagmap[n-1+x-y]==1 || antidiagmap[x+y]==1){
            return false;
        }else{
            return true;
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        string b(n,'.');
        vector<string> cb(n,b);
        vector<pair<int,int>> qlocs;
        vector<int> rowmap(n,0);
        vector<int> colmap(n,0);
        vector<int> diagmap(2*n - 1,0);
        vector<int> antidiagmap(2*n - 1,0);
        rec(ans,cb,rowmap,colmap,diagmap,antidiagmap,n,0);
        return ans;
        
    }
};
