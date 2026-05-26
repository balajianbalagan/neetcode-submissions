class Solution {
public:
    void helper(vector<vector<char>>& g, int x,int y){
        int r = g.size(), c = g[0].size();
        if(x>=r || x<0 || y<0 || y>=c){
            return;
        }
        if(g[x][y]=='0'){
            return;
        }
            
        g[x][y]='0';
        helper(g,x-1,y);
        helper(g,x,y-1);
        helper(g,x,y+1);
        helper(g,x+1,y);
        
    }
    int numIslands(vector<vector<char>>& grid) {
        int ni = 0;
        int row = grid.size();
        int col = row ? grid[0].size() : 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    ni++;
                    helper(grid,i,j);
                }
            }
        }

        return ni;
    }
};
