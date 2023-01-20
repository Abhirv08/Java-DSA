class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(i == 0 && j == 0) dp[0][0] = grid[0][0];
                else{
                    int up = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) down = dp[i][j-1];
                    
                    dp[i][j] = grid[i][j] + Math.min(up, down);
                 }
            }
        }
        
        return dp[m-1][n-1];
    }
}