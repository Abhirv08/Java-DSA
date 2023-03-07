class Solution {
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        // Arrays.sort(coins);
        int[][] dp = new int[n][amount+1];
        for(int[] r: dp) Arrays.fill(r, -1);
        int minCoins = findCoins(coins, amount, n - 1, dp);
        return minCoins == Integer.MAX_VALUE - 1 ? -1 : minCoins;
    }

    private static int findCoins(int[] coins, int amount, int idx, int[][] dp){
        if(idx < 0) return Integer.MAX_VALUE - 1;

        if(amount == coins[idx]) return 1;
        
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notTaken = findCoins(coins, amount, idx - 1, dp);
        int taken = Integer.MAX_VALUE;
        if(amount >= coins[idx]){
            taken = 1 + findCoins(coins, amount - coins[idx], idx, dp);
        }

        return dp[idx][amount] = Math.min(notTaken, taken);
    }
}