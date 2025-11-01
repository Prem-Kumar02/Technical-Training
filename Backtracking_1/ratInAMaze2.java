import java.util.*;

class ratInAMaze2 {
    static final int BOUND = 1000000; // grid size (0 to 10^6)
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    // check if current cell is inside bounds and not blocked or visited
    public boolean safe(int row, int col, Set<String> blocked, Set<String> vis) {
        if (row < 0 || col < 0 || row >= BOUND || col >= BOUND) return false;
        String key = row + "," + col;
        return !blocked.contains(key) && !vis.contains(key);
    }

    // DFS traversal
    public boolean dfs(int r, int c, int tr, int tc, Set<String> blocked, Set<String> vis) {
        // reached the target
        if (r == tr && c == tc) return true;

        vis.add(r + "," + c);

        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (safe(nr, nc, blocked, vis)) {
                if (dfs(nr, nc, tr, tc, blocked, vis)) return true;
            }
        }
        return false;
    }

    public boolean isEscapePossible(int[][] blockedArr, int[] source, int[] target) {
        Set<String> blocked = new HashSet<>();
        for (int[] b : blockedArr) blocked.add(b[0] + "," + b[1]);

        Set<String> vis = new HashSet<>();

        // Run DFS from source to target
        return dfs(source[0], source[1], target[0], target[1], blocked, vis);
    }
}

