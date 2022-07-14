class Solution {
    
    public int change(int amount, int[] coins) {
        
        int[][] memo = new int[coins.length+1][amount+1];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        
        return coinChange(coins, amount, coins.length, memo);
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