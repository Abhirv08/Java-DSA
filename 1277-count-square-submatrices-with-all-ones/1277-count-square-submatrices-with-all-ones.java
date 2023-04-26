class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int[][] mat = new int[m][n];
        
        mat[0] = matrix[0];
        for(int r = 0; r < m; r++){
            mat[r][0] = matrix[r][0];
        }
        
        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                if(matrix[r][c] == 1){
                    mat[r][c] = 1 + Math.min(mat[r-1][c], Math.min(mat[r][c-1], mat[r-1][c-1]));
                }
            }
        }
        
        int ans = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                ans += mat[r][c];
            }
        }
        
        return ans;
    }
}