class Solution {
    public int coinChange(int[] coins, int amount) {    
        int[][] memo = new int[coins.length + 1][amount+1];
        
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        int ans = countCoins(coins, amount, coins.length, memo);
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans ;
    }
    
    private int countCoins(int[] coins, int amount, int n, int[][] memo){
        if(amount == 0){
            return 0;
        }
        
        if(n == 0){
            return Integer.MAX_VALUE - 1;
        }
        
        if(memo[n][amount] != -1){
            return memo[n][amount];
        }
        
        if(coins[n-1] > amount){
            return countCoins(coins, amount, n-1, memo);
        }
        
        int withConsidering = 1 + countCoins(coins, amount - coins[n-1], n, memo);
        int withoutConsidering = countCoins(coins, amount, n - 1, memo);
        
        memo[n][amount] = Math.min(withoutConsidering, withConsidering);
        
        return Math.min(withoutConsidering, withConsidering);
    }
    
    private int countCoins(int[] coins, int amount, int n){
        int[][] memo = new int[n+1][amount+1];
        
        for(int j = 0; j < amount+1; j++){
            memo[0][j] = Integer.MAX_VALUE - 1;
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