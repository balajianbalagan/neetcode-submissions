class Solution {

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (
                    nr >= 0 &&
                    nr < heights.length &&
                    nc >= 0 &&
                    nc < heights[0].length &&
                    !visited[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]
                ) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        // Pacific borders
        for (int i = 0; i < rows; i++) {
            pacific[i][0] = true;
            pacQ.offer(new int[]{i, 0});
        }

        for (int j = 0; j < cols; j++) {
            pacific[0][j] = true;
            pacQ.offer(new int[]{0, j});
        }

        // Atlantic borders
        for (int i = 0; i < rows; i++) {
            atlantic[i][cols - 1] = true;
            atlQ.offer(new int[]{i, cols - 1});
        }

        for (int j = 0; j < cols; j++) {
            atlantic[rows - 1][j] = true;
            atlQ.offer(new int[]{rows - 1, j});
        }

        bfs(heights, pacQ, pacific);
        bfs(heights, atlQ, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }
}