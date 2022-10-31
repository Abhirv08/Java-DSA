class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0;        
        while(row < m){
            int i = row, j = 0;
            int num = matrix[i][j];
            while(i < m && j < n){
                if(matrix[i][j] != num){
                    return false;
                }
                i++; j++;
            }
            row++;
        }
        
        int col = 1;
        while(col < n){
            int i = 0, j = col;
            int num = matrix[i][j];
            while(i < m && j < n){
                if(matrix[i][j] != num){
                    return false;
                }
                i++; j++;
            }
            col++;
        }
        
        
        return true;
    }
}