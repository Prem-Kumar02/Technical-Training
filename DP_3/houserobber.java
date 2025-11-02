

class houserobber {
    public int rec(int[] nums,int idx,int[] dp){
        if(idx==0) return nums[idx];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick=nums[idx]+rec(nums,idx-2,dp);
        int notPick=0+rec(nums,idx-1,dp);
        return dp[idx]=Math.max(pick,notPick);
    }

    public int tab(int[] nums,int[] dp){
        dp[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            int pick=nums[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int notPick=0+dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }

    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        //Arrays.fill(dp,-1);
        //return rec(nums,nums.length-1,dp);
        return tab(nums,dp);
    }
}
