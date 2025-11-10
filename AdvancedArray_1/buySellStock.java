class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int bought=Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<bought){
                bought=prices[i];
            }
            profit=Math.max(profit,prices[i]-bought);
        }
        return profit;
    }
}