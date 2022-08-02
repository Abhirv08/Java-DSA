class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        
        while(min <= max){
            int mid = (min + max)/2;
            int count = getCount(matrix, mid, n);
            if(count < k){
                min = mid + 1;
            }else{
                max = mid - 1;
            }           
            
        }
        
        return min; 
    }
    
    private int getCount(int[][] matrix, int mid, int n){
        int row = 0;
        int col = n - 1;
        int count = 0;
        
        while(row < n && col >= 0){
            if(matrix[row][col] <= mid){
                count += col + 1;
                row++;
            }else{
                col--;
            }
        }
        return count;
    }
    
}