import java.util.Arrays;
class Solution {
    public int solve(int[] coins, int idx, int amount,int[][] dp){
        if(idx==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int)1e9;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int notTake=0+solve(coins,idx-1,amount,dp);
        int take=(int)1e9;
        if(coins[idx]<=amount){
            take=1+solve(coins,idx,amount-coins[idx],dp);
        }
        return dp[idx][amount]=Math.min(take,notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int ans=0;
        ans=solve(coins,n-1,amount,dp);
        if(ans>=(int)1e9){
            return -1;
        }
        return ans;
    }
}