class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        
        return maxProfit(prices, 0, 0, dp);
    }
    
    static int maxProfit(int[] prices, int i, int flag, int[][] dp){
        if(i >= prices.length) return 0;
        
        if(dp[i][flag] != -1) return dp[i][flag]; 
        
        if(flag == 0){   // have to buy
            int ifBought = -prices[i] + maxProfit(prices, i + 1, 1, dp);
            int ifNotBought = maxProfit(prices, i + 1, 0, dp);
            
            return dp[i][flag] = Math.max(ifBought, ifNotBought);
        }// have to sell
        int ifSold = prices[i] + maxProfit(prices, i + 2, 0, dp);
        int ifNotSold = maxProfit(prices, i + 1, 1, dp);
        
        return dp[i][flag] = Math.max(ifSold, ifNotSold);
    }
}