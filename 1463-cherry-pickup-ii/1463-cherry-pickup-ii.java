class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        dp = new int[m][n][n];
        for(int[][] mat: dp){
            for(int[] arr: mat){
                Arrays.fill(arr, -1);
            }
        }
        
        return maxCherryPick(grid, 0, 0, n-1);
    }
    
    int[][] paths = {{1, -1}, {1, 0}, {1, 1}};
    private int maxCherryPick(int[][] grid, int row, int col1, int col2){
        
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
        int ans = Integer.MIN_VALUE;
        for(int[] path1: paths){
            int nr = row + path1[0];
            int nc1 = col1 + path1[1];
            if(nr < grid.length && nc1 >= 0 && nc1 < grid[0].length){
                for(int[] path2: paths){
                    int nc2 = col2 + path2[1];

                    if(nc2 >= 0 && nc2 < grid[0].length){
                        int sum = grid[row][col1] + maxCherryPick(grid, nr, nc1, nc2);
                        if(col1 != col2){
                            sum += grid[row][col2];
                        }
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        
        if(ans == Integer.MIN_VALUE) ans = 0;
        else return dp[row][col1][col2] = ans;
        
        if(col1 == col2){
            return dp[row][col1][col2] = ans + grid[row][col1];
        }
        
        return dp[row][col1][col2] = ans + grid[row][col1] + grid[row][col2];
    }
}