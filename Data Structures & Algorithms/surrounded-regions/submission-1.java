class Solution {
    public void bfsFill(char[][] board,int i,int j){
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[]{i,j});
        int[][] dirs = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.remove();
            
            for(int[] d:dirs){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr<0 || nr>=rows || nc<0 || nc>=cols){
                    return;
                }
                if(visited[nr][nc]==1 || board[nr][nc]=='X'){
                    continue;
                }else{
                    visited[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                    arr.add(new int[]{nr,nc});
                }

            }
        }
        for(int k=0;k<arr.size();k++){
            int ri = arr.get(k)[0];
            int cj = arr.get(k)[1];
            board[ri][cj] = 'X';
        }
    }
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        /*
        idea:
        we are going to bfs on O
        if i can reach any border that means its not surrounded
        and we only fill if its surrounded
        */
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    bfsFill(board,i,j);
                }
            }
        }

    }
}
