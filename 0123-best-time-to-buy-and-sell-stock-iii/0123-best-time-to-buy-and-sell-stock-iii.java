class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] mat: dp){
            for(int[] r: mat){
                Arrays.fill(r, -1);
            }
        }
        return findMaxProfit(prices, 0, 1, 2, dp);
    }
    
    private int findMaxProfit(int[] prices, int i, int buy, int trans, int[][][] dp){
        if(i == prices.length || trans == 0) return 0;
        
        if(dp[i][buy][trans] != -1) return dp[i][buy][trans];
        
        if(buy == 1){
            int ifBuy = -prices[i] + findMaxProfit(prices, i+1, 0, trans, dp);
            int dontBuy = 0 + findMaxProfit(prices, i + 1, 1, trans, dp);
            
            return dp[i][buy][trans] = Math.max(ifBuy, dontBuy);
        }else{
            int sell = prices[i] + findMaxProfit(prices, i+1, 1, trans-1, dp);
            int dontSell = 0 + findMaxProfit(prices, i+1, 0, trans, dp);
            
            return dp[i][buy][trans] = Math.max(sell, dontSell);
        }        
    }
}