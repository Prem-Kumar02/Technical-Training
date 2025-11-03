class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        // Base cases
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 0; // 0 floors -> 0 trials
            dp[i][1] = 1; // 1 floor -> 1 trial
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j; // 1 egg -> try all floors
        }

        // Build DP table
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int eggBreaks = dp[i - 1][x - 1];
                    int eggSurvives = dp[i][j - x];
                    int worst = 1 + Math.max(eggBreaks, eggSurvives);
                    dp[i][j] = Math.min(dp[i][j], worst);
                }
            }
        }
        return dp[k][n];
    }
}
