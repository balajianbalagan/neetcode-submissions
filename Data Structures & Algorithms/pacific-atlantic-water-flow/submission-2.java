class Solution {
    public void solve(int[][] heights,int[][] ocean,int rows,int cols,int endi,int endj){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(ocean[i][j]==0){
                    int[][] visited = new int[rows][cols];
                    bfs(heights,ocean,i,j,endi,endj,heights[i][j],visited);
                }
                
            }
            
        }
    }
    public boolean bfs(int[][] heights,int[][] ocean,int i,int j,int endi,int endj,int num,int[][] visited){
        //invalid oob
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length){
            return false;
        }
        
        if( ocean[i][j]==-1 || heights[i][j]>num){
            return false;
        }
        if(ocean[i][j]==1 && heights[i][j]<=num){
            return true;
        }
        //base case
        if((i==endi || j==endj) && heights[i][j]<=num){
            ocean[i][j]=1;
            return true;
        }
        if(visited[i][j]==1){
            return false;
        }
        visited[i][j]=1;
        // go through 4 directions and see if atleast one is possible
        if(bfs(heights,ocean,i-1,j,endi,endj,heights[i][j],visited) || bfs(heights,ocean,i+1,j,endi,endj,heights[i][j],visited) || bfs(heights,ocean,i,j+1,endi,endj,heights[i][j],visited) || bfs(heights,ocean,i,j-1,endi,endj,heights[i][j],visited)){
            ocean[i][j]=1;
            return true;
        }else{
            ocean[i][j]=-1;
            return false;
        }
    
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] pacific = new int[rows][cols];
        int[][] atlantic = new int[rows][cols];

        solve(heights,pacific,rows,cols,0,0);
        solve(heights,atlantic,rows,cols,rows-1,cols-1);

        List<List<Integer>> arr = new ArrayList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(pacific[i][j]+" ");
                
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    arr.add(List.of(i,j));
                }
            }
            System.out.println("------------");
        }
        return arr;
    }
}
