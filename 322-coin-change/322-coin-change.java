class Solution {
    public int coinChange(int[] coins, int amount) {                
        return countCoins(coins, amount, coins.length);
    }
    
    private int countCoins(int[] coins, int amount, int n){
        int[][] memo = new int[n+1][amount+1];
        
        for(int j = 0; j < amount+1; j++){
            memo[0][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int j = 1; j < amount+1; j++){
            memo[1][j] = coins[0] % j == 0 ? coins[0]/j : Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(coins[i-1] > j){
                    memo[i][j] = memo[i-1][j];
                }else{
                    memo[i][j] = Math.min(1 + memo[i][j - coins[i-1]] , memo[i-1][j]);
                }
            }
        }
        
        return memo[n][amount] == Integer.MAX_VALUE - 1 ? -1 : memo[n][amount];
    }
}