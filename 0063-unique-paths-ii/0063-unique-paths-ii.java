class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[m-1][n-1] == 1) return 0;
        dp = new int[m][n];
        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }
        return findUniquePaths(grid, m, n, 0, 0);
    }
    
    private int findUniquePaths(int[][] grid, int m, int n, int row, int col){
        if(row == m-1 && col == n-1) return 1;
        if(row >= m || col >= n) return 0;
        if(grid[row][col] == 1) return 0;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        return dp[row][col] = findUniquePaths(grid, m, n, row+1, col) + findUniquePaths(grid, m, n, row, col+1);
    }
}