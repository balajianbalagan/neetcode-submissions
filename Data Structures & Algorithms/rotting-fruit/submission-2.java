class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                   
                    q.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }

        while(!q.isEmpty()){
            int s = q.size();
            
            for(int k=0;k<s;k++){
                ArrayList<Integer> pos = q.poll();
            int i = pos.get(0);
            int j = pos.get(1);
            System.out.println(i+" "+j);
            int changed = 0;
            if(i-1>=0){
                if(grid[i-1][j]==1){
                    
                    grid[i-1][j] = 2;
                    // q.add({i-1,j});
                    q.add(new ArrayList<>(List.of(i-1,j)));
                    changed++;
                }
            }
            if(j-1>=0){
                if(grid[i][j-1]==1){
                    grid[i][j-1] = 2;
                    // q.add({i,j-1});
                    q.add(new ArrayList<>(List.of(i,j-1)));
                    changed++;
                }
            }
            if(i+1<grid.length){
                if(grid[i+1][j]==1){
                    grid[i+1][j] = 2;
                    // q.add({i+1,j});
                    q.add(new ArrayList<>(List.of(i+1,j)));
                    changed++;
                }
            }
            if(j+1<grid[0].length){
                if(grid[i][j+1]==1){
                    grid[i][j+1] = 2;
                    // q.add({i,j+1});
                    q.add(new ArrayList<>(List.of(i,j+1)));
                    changed++;
                }
            }
            // if(changed!=0){
            //     minutes++;
            // }
            }
            minutes++;
            
        }



        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        if(minutes>0)return minutes-1;

        return minutes;
    }
}
