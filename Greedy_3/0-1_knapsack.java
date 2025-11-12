import java.util.*;
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        int[][] dp=new int[n][W+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(W,val,wt,n-1,dp);
    }
    public int helper(int W,int[] val, int[] wt, int idx,int[][] dp){
        if(idx==0){
            if(wt[idx]<=W){
                return val[idx];
            } else{
                return 0;
            }
        }
        if(dp[idx][W]!=-1) return dp[idx][W];
        
        int notTake=0+helper(W,val,wt,idx-1,dp);
        int take=(int) -1e9;
        if(wt[idx]<=W){
            take=val[idx]+helper(W-wt[idx],val,wt,idx-1,dp);
        }
        return dp[idx][W]= Math.max(take,notTake);
    }
}
