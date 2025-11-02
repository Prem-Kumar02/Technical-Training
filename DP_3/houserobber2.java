import java.util.*;

class houserobber2 {
    // Linear robber with tabulation
  public int robLinearTab(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    public int robHelperMem(int[] nums, int idx, int[] dp) {
        if (idx == 0) return nums[0];
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + robHelperMem(nums, idx - 2, dp);
        int notPick = robHelperMem(nums, idx - 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    // Linear robber with memoization
    public int robLinear(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robHelperMem(nums, n - 1, dp);
    }

    // Main function for circular houses
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] excludeFirst = Arrays.copyOfRange(nums, 1, n); // 1 → n-1
        int[] excludeLast = Arrays.copyOfRange(nums, 0, n - 1); // 0 → n-2

        int ans1 = robLinear(excludeFirst);
        int ans2 = robLinear(excludeLast);

        return Math.max(ans1, ans2);
    }
}

