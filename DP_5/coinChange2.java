import java.util.Arrays;
class Solution {
    public int f(int idx,int amount,int[] coins,int[][] dp){
        if(idx==0){
            if(amount % coins[0]==0) return 1;
            else return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake=f(idx-1,amount,coins,dp);
        int take=0;
        if(coins[idx]<=amount){
            take=f(idx,amount-coins[idx],coins,dp);
        }
        return dp[idx][amount]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,amount,coins,dp);
    }
}