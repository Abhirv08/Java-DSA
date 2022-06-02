class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] ans = new int[cols][rows];
        int ansRow = 0;
        int ansCol = 0;
        for(int i = 0; i < rows; i++, ansCol++){
            ansRow = 0;
            for(int j = 0; j < cols; j++, ansRow++){
                ans[ansRow][ansCol] = matrix[i][j];
            }
        }
        return ans;
    }
}