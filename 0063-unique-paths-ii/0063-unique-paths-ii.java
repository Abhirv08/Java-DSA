class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        
        for(int col = 0; col < n; col++){
            if(grid[0][col] == 1){
                break;
            }
            dp[0][col] = 1;
        }
        
        for(int row = 0; row < m; row++){
            if(grid[row][0] == 1){
                break;
            }
            dp[row][0] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}