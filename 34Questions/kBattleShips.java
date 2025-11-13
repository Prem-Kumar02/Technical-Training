import java.util.*;

class Solution {

    static class Ship {
        int R, C, D;
        Ship(int R, int C, int D) {
            this.R = R;
            this.C = C;
            this.D = D;
        }
    }

    public boolean canPlaceShips(int N, int M, Ship[] ships) {
        if (ships.length > N * M) return false;

        List<int[]> placed = new ArrayList<>();  
        List<Ship> placedInfo = new ArrayList<>(); 
        return backtrack(0, ships, placed, placedInfo, N, M);
    }

    private boolean backtrack(int idx, Ship[] ships, 
                              List<int[]> placed, List<Ship> placedInfo,
                              int N, int M) {
        if (idx == ships.length) return true; 

        Ship s = ships[idx];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (isSafe(r, c, s, placed, placedInfo)) {
                    placed.add(new int[]{r, c});
                    placedInfo.add(s);

                    if (backtrack(idx + 1, ships, placed, placedInfo, N, M))
                        return true;

                    placed.remove(placed.size() - 1);
                    placedInfo.remove(placedInfo.size() - 1);
                }
            }
        }

        return false; 
    }

    private boolean isSafe(int r2, int c2, Ship s2,
                           List<int[]> placed, List<Ship> placedInfo) {

        for (int i = 0; i < placed.size(); i++) {
            int[] p = placed.get(i);
            int r1 = p[0], c1 = p[1];

            Ship s1 = placedInfo.get(i); 

            // Row attack (same row)
            if (r1 == r2 && Math.abs(c1 - c2) <= s1.R) return false;

            // Column attack (same column)
            if (c1 == c2 && Math.abs(r1 - r2) <= s1.C) return false;

            // Diagonal attack (same diagonal and within range)
            if (Math.abs(r1 - r2) == Math.abs(c1 - c2)
                && Math.abs(r1 - r2) <= s1.D) return false;
        }
        return true;
    }
}
