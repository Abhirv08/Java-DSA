class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        
        for(int[][] mat: dp){
            for(int[] r: mat){
                Arrays.fill(r, -1);
            }
        }
        
        return maximize(prices, 0, k, 0, dp);
    }
    
    private int maximize(int[] prices, int idx, int k, int state, int[][][] dp){
        if(idx == prices.length || k == 0) return 0;
        
        if(dp[idx][k][state] != -1)  return dp[idx][k][state];
        
        if(state > 0){      // 1 for sell
            int sell = prices[idx] + maximize(prices, idx+1, k-1, 0, dp);
            int dontSell = maximize(prices, idx+1, k, 1, dp);
            
            return dp[idx][k][state] = Math.max(sell, dontSell);
        }
        // 0 for Buy
        int buy = -prices[idx] + maximize(prices, idx+1, k, 1, dp);
        int dontBuy = maximize(prices, idx+1, k, 0, dp);

        return dp[idx][k][state] = Math.max(buy, dontBuy);
        
    }
}