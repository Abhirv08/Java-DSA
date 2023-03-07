class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < amount + 1; j++){
                if(i == 0){
                    if(j%coins[0] == 0) dp[i][j] = 1;
                }else{
                    int notTaken = dp[i - 1][j];
                    int taken = 0;
                    if(j >= coins[i]){
                        taken = dp[i][j - coins[i]];
                    }
                    dp[i][j] = notTaken + taken;
                }
            }
        }
        
        return dp[n - 1][amount];
    }
}