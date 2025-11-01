import java.util.*;

class ratInAMaze {
    public boolean blocksafe(int[][] blocked, int row, int col) {
        int n = blocked.length;
        for (int i = 0; i < n; i++) {
            if (blocked[i][0] == row && blocked[i][1] == col) {
                return false;
            }
        }
        return true;
    }

    public boolean safe(int[][] blocked, int row, int col, boolean[][] vis) {
        int n = vis.length;
        int m = vis[0].length;
        // boundary + visited + blocked checks
        if (row < 0 || col < 0 || row >= n || col >= m) return false;
        if (!vis[row][col] && blocksafe(blocked, row, col)) {
            return true;
        }
        return false;
    }

    public boolean fun(int[][] blocked, int r, int c, int tr, int tc, boolean[][] vis) {
        // base condition: reached target
        if (r == tr && c == tc) return true;

        vis[r][c] = true;

        // down
        if (safe(blocked, r + 1, c, vis)) {
            if (fun(blocked, r + 1, c, tr, tc, vis)) return true;
        }
        // left
        if (safe(blocked, r, c - 1, vis)) {
            if (fun(blocked, r, c - 1, tr, tc, vis)) return true;
        }
        // right
        if (safe(blocked, r, c + 1, vis)) {
            if (fun(blocked, r, c + 1, tr, tc, vis)) return true;
        }
        // up
        if (safe(blocked, r - 1, c, vis)) {
            if (fun(blocked, r - 1, c, tr, tc, vis)) return true;
        }

        return false; // no path found
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int startRow = source[0], startCol = source[1];
        int targetRow = target[0], targetCol = target[1];

        int n = 1000; 
        boolean[][] vis = new boolean[n][n];

        return fun(blocked, startRow, startCol, targetRow, targetCol, vis);
    }
}

