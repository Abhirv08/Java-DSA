class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix.length+1];
        for(int[] d: dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < matrix[0].length; col++){
            int minPos = findMinValue(matrix, 0, col, dp);
            ans = Math.min(minPos, ans);
        }
        
        return ans;
    }
    
    private int findMinValue(int[][] mat, int row, int col, int[][] dp){
        if(col < 0 || col == mat.length) return Integer.MAX_VALUE;
        
        if(row == mat.length - 1){
            return mat[row][col];
        }
        
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        
        int x = findMinValue(mat, row+1, col-1, dp);
        int y = findMinValue(mat, row+1, col, dp);
        int z = findMinValue(mat, row+1, col+1, dp);
        
        return dp[row][col] = mat[row][col] + Math.min(x, Math.min(y, z));
    }
}