class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;           
            }
        }
        
        
        int i = 0, j = n - 1;
        
        while(j - i > 0){
            for(int row = 0; row < n; row++){
                int temp = mat[row][i];
                mat[row][i] = mat[row][j];
                mat[row][j] = temp;
            }
            
            i++;
            j--;
        }
    }
}