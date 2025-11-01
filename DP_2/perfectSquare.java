import java.util.*;

class perfectSquare {
    public int rec(int n){
        if(n==0) return 0;
        int ans=n;
        for(int i=1; i*i<=n; i++){
            ans=Math.min(ans,1+rec(n-i*i));
        }
        return ans;
        
    }
    public int mem(int n,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=n;
        for(int i=1; i*i<=n; i++){
            ans=Math.min(ans,1+mem(n-i*i,dp));
        }
        return dp[n]=ans;
        
    }
    public int tab(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=n; j++){
                if(i-j*j>=0){
                    dp[i]=Math.min(dp[i],1+dp[i-j*j]);
                } 
            }
        }
        return dp[n];
    }
    public int numSquares(int n) {
        //return rec(n);
        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return mem(n,dp);
        return tab(n);
    }
}