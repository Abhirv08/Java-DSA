class Solution {
    int[][] dp ;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return paths(grid, 0, 0);
    }
    
    private int paths(int[][] grid, int row, int col){
        if(row == grid.length - 1 && col == grid[0].length-1) return grid[grid.length - 1][grid[0].length - 1];
        if(row == grid.length || col == grid[0].length) return 10000;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int down = paths(grid, row+1, col);
        int right = paths(grid, row, col+1);
        
        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }
}