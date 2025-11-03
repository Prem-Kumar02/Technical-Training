class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If not visited and land found
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        // mark current as visited
        vis[row][col] = true;

        // 4 directions
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int newRow = row + dRow[k];
            int newCol = col + dCol[k];

            // check boundaries
            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n) {
                if (grid[newRow][newCol] == '1' && !vis[newRow][newCol]) {
                    dfs(newRow, newCol, grid, vis);
                }
            }
        }
    }
}
