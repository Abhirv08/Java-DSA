class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0 ; i<prices.length ; i++){
            for(int j=0 ; j<2 ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        
        return helper(prices , 0 , 1 , k , dp);
    }
    
    // canBuy will be 0 if we are holding a stock and hence we have to sell it first then only we can buy next.
    private int helper(int[] prices , int i , int canBuy , int transactionsLeft , int[][][] dp){
        if(transactionsLeft == 0) return 0;
        if(i >= prices.length) return 0;
        
        if(dp[i][canBuy][transactionsLeft] != -1) return dp[i][canBuy][transactionsLeft];
        
        if(canBuy == 1){
            int buy = -prices[i] + helper(prices , i+1 , 0 , transactionsLeft , dp); // transactionsLeft will remain as it is as the transction gets completed when we sell it. AND  prices[i] will be subtracted from profit as we are buying stock.
            int dontBuy = helper(prices , i+1 , 1 , transactionsLeft , dp); // canBuy will remain 1 as we have not bought.
            
            dp[i][canBuy][transactionsLeft] = Math.max(buy , dontBuy);
        }else{//  We have to sell
            int sell = prices[i] + helper(prices , i+1 , 1 , transactionsLeft-1 , dp);// transactionsLeft will get reduced as the transction gets completed when we sell it.
            int dontSell = helper(prices , i+1 , 0 , transactionsLeft , dp);
            
            dp[i][canBuy][transactionsLeft] = Math.max(sell , dontSell);
        }
        return dp[i][canBuy][transactionsLeft];
    }
}