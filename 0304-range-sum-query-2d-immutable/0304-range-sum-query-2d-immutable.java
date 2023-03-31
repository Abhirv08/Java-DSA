class NumMatrix {
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        prefixSum = new int[rows+1][cols+1];
        
        prefixSum[1][1] = matrix[0][0];
        for(int j = 1; j < cols; j++){
            prefixSum[1][j+1] = prefixSum[1][j] + matrix[0][j];
        }
        
        for(int i = 1; i < rows; i++){
            prefixSum[i+1][1] = prefixSum[i][1] + matrix[i][0];
        }
        
        for(int i = 2; i < rows+1; i++){
            for(int j = 2; j < cols+1; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] +
                    + matrix[i-1][j-1] - prefixSum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 += 1; col1 += 1; row2 += 1; col2 += 1;
        int ans = prefixSum[row2][col2] + prefixSum[row1-1][col1-1] - prefixSum[row1-1][col2] - prefixSum[row2][col1-1]; 
        
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */