class Solution {
    public int rec(int[][] mat,int r, int c,int n, int m,int[][] dp){
        if (r < 0 || r >= n || c >= m) return 0;
        
         if (dp[r][c] != -1) return dp[r][c];
        
        int rightUp = mat[r][c] + rec(mat, r - 1, c + 1, n, m, dp);
        int right = mat[r][c] + rec(mat, r, c + 1, n, m, dp);
        int rightDown = mat[r][c] + rec(mat, r + 1, c + 1, n, m, dp);
        return dp[r][c]= Math.max(rightUp, Math.max(right, rightDown));
    }
    public int tab(int[][] mat,int[][] dp){
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            dp[i][0] = mat[i][0];
        }

        for (int c = 1; c < m; c++) {
            for (int r = 0; r < n; r++) {
                int leftUp = (r > 0) ? dp[r - 1][c - 1] : 0;
                int left = dp[r][c - 1];
                int leftDown = (r < n - 1) ? dp[r + 1][c - 1] : 0;

                dp[r][c] = mat[r][c] + Math.max(left, Math.max(leftUp, leftDown));
            }
    }

    int maxGold = 0;
    for (int i = 0; i < n; i++) {
        maxGold = Math.max(maxGold, dp[i][m - 1]);
    }

    return maxGold;
        
    }
    public int maxGold(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp = new int[n][m];
        //for (int[] row : dp) Arrays.fill(row, -1);
        //int max=Integer.MIN_VALUE;
        // for(int i=0;i<n; i++){
        //     max=Math.max(max,rec(mat,i,0,n,m,dp));
        // }
        return tab(mat,dp);
    }
}