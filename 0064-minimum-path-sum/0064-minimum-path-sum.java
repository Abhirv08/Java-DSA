class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return minPathSum(grid, 0, 0, dp);
    }
    
    private int minPathSum(int[][] grid, int r, int c, int[][] dp){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
            return 100000;
        }
        
        if(r == grid.length - 1 && c == grid[0].length - 1){
            return grid[r][c];
        }
        
        if(dp[r][c] != -1) return dp[r][c];
        
        int pathDown = minPathSum(grid, r+1, c, dp);
        int pathRight = minPathSum(grid, r, c+1, dp);
        
        return dp[r][c] = grid[r][c] + Math.min(pathDown, pathRight);
    }
}