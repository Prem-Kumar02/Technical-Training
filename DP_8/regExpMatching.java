class Solution {
    public boolean f(String s, String p, int i, int j,Boolean[][] dp){
        if(i==0 && j==0) return true;
        if(j==0) return false;

        if (dp[i][j] != null) return dp[i][j];

        boolean ans;
        if(p.charAt(j-1)=='*'){
            //no occurence
            ans=f(s,p,i,j-2,dp);

            //one or more occurence
            if(i>0 && (s.charAt(i-1)==p.charAt(j-2) ||  p.charAt(j-2)=='.')){
                ans=ans || f(s,p,i-1,j,dp);
            } 
        } else if(i>0 && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')){
            ans=f(s,p,i-1,j-1,dp);
        } else {
            ans=false;
        }
        return dp[i][j]=ans;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean[][] dp=new Boolean[n+1][m+1];
        return f(s,p,n,m,dp);
    }
}