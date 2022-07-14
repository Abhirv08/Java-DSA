class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n+1][amount+1];
        for(int i = 0; i < n+1; i++){
            memo[i][0] = 1;
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(coins[i-1] > j){
                    memo[i][j] = memo[i-1][j];
                }else{
                    memo[i][j] = memo[i][j - coins[i-1]] + memo[i-1][j];
                }
            }
        }
        
        return memo[n][amount];
        
        // return coinChange(coins, amount, coins.length, memo);
    }
    
    private int coinChange(int[] coins, int amount, int n, int[][] memo){
        if(amount == 0){
            return 1;
        }
        
        if(n == 0){
            return 0;
        }   
        
        if(memo[n][amount] != -1){
            return memo[n][amount];
        }
        
        if(coins[n-1] > amount){
            return coinChange(coins, amount, n-1, memo);
        }
        
        int withTakingCoin = coinChange(coins, amount - coins[n-1], n, memo);
        
        int withoutTakingCoin = coinChange(coins, amount, n-1, memo);
        
        memo[n][amount] = withTakingCoin + withoutTakingCoin;
        
        return withTakingCoin + withoutTakingCoin;
    }
}