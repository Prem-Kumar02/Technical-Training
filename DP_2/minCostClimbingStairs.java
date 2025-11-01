import java.util.*;

public class minCostClimbingStairs {
  //memoization
  public int help(int[] cost,int i,int[] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int left=cost[i]+help(cost,i+1,dp);
        int right=cost[i]+help(cost,i+2,dp);

        return dp[i]=Math.min(left,right);
    }
    //tabulation
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n]; // memoization array
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // Minimum of last two since we can end at n or n-1
        return Math.min(dp[n - 1], dp[n - 2]);
        //Arrays.fill(dp, -1);
        //return Math.min(help(cost,0,dp),help(cost,1,dp));
    }
}
