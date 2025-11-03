public class noOfClosedIsland {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    if (dfs(i, j, grid, vis, m, n)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int row, int col, int[][] grid, boolean[][] vis, int m, int n) {
        // Base case: out of bounds → touches boundary (not closed)
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }

        // Already visited or water
        if (grid[row][col] == 1 || vis[row][col]) {
            return true;
        }

        vis[row][col] = true;

        // Explore 4 directions
        boolean down = dfs(row + 1, col, grid, vis, m, n);
        boolean up = dfs(row - 1, col, grid, vis, m, n);
        boolean right = dfs(row, col + 1, grid, vis, m, n);
        boolean left = dfs(row, col - 1, grid, vis, m, n);

        // Island is closed only if all directions are closed
        return down && up && right && left;
    }
}
