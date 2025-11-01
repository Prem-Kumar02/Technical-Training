import java.util.*;

public class fibonacci {
  //Memoization
  public int helper(int n, int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];

        return helper(n-1,dp)+helper(n-2,dp);
    }
  public int fib(int n){
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
