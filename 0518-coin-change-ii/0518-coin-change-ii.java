class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }
        
        return findWays(coins, amount, n-1, dp);
    }
    
    private int findWays(int[] coins, int amount, int idx, int[][] dp){
        if(idx < 0){
            if(amount == 0) return 1;
            
            return 0;
        }
        
        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        int notTaken = findWays(coins, amount, idx - 1, dp);
        int taken = 0;
        if(amount >= coins[idx]){
            taken = findWays(coins, amount - coins[idx], idx, dp);
        }
        
        return dp[idx][amount] = notTaken + taken;
    }
    
}