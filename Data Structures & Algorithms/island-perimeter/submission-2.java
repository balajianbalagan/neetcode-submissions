class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] pts = q.poll();
                        int x = pts[0];
                        int y = pts[1];
                        if(grid[x][y]==-1){
                            continue;
                        }
                        grid[x][y] = -1;
                        int perimeter = 4;
                        for (int k = 0; k < dirs.length; k++) {
                            int nr = x + dirs[k][0];
                            int nc = y + dirs[k][1];
                            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] == 0) {
                                continue;
                            }
                            if (grid[nr][nc] == -1) {
                                perimeter--;
                                continue;
                            }
                            perimeter--;
                            q.add(new int[] {nr, nc});
                        }
                        peri += perimeter;
                        System.out.println("i: "+x+", j: "+y+" | peri: "+perimeter);
                    }
                }
            }
        }

        // peri = 2*peri + 2;
        return peri;
    }
}