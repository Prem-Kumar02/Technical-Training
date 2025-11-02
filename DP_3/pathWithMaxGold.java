class PathWithMaxGold {
    private int n, m;

    public int getMaximumGold(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int maxGold = 0;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, vis, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0 || vis[r][c]) {
            return 0;
        }

        vis[r][c] = true;

        int goldHere = grid[r][c];

        int up = dfs(grid, vis, r - 1, c);
        int down = dfs(grid, vis, r + 1, c);
        int left = dfs(grid, vis, r, c - 1);
        int right = dfs(grid, vis, r, c + 1);

        vis[r][c] = false;

        return goldHere + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
