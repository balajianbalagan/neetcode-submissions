class Solution {
public:
    void dfs(vector<vector<int>>& g, int x,int y,int &subans){
        int r = g.size();
        int c = g[0].size();
        if(x>=r || y>=c || x<0 || y<0){
            return;
        }
        if(g[x][y]==1){
            subans++;
            g[x][y] = 0;
            dfs(g,x-1,y,subans);
            dfs(g,x+1,y,subans);
            dfs(g,x,y+1,subans);
            dfs(g,x,y-1,subans);
        }
        
    }
    int maxAreaOfIsland(vector<vector<int>>& g) {
        int maxArea = 0;
        int r = g.size();
        int c = g[0].size();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(g[i][j]==1){
                    int subarea = 0;
                    dfs(g,i,j,subarea);
                    maxArea = max(maxArea,subarea);
                }
                
            }
        }



        return maxArea;
    }
};
