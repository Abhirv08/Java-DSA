class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int row_start = 0;
        int col_start = 0;
        int row_end = n-1;
        int col_end = n-1;
        int total = n*n;
        int count = 1;
        while (total > 0 ){
            for (int i = col_start; total>0 && i <= col_end; i++) {
                ans[row_start][i] = count;
                count++;
                total--;
            }
            row_start++;
            for (int i = row_start; total>0 && i <= row_end; i++) {
                ans[i][col_end] = count;
                count++;
                total--;
            }
            col_end--;
            for (int i = col_end; total>0 && i >= col_start ; i--) {
                ans[row_end][i] = count;
                count++;
                total--;
            }
            row_end--;
            for (int i = row_end; i >= row_start ; i--) {
                ans[i][col_start] = count;
                count++;
                total--;
            }
            col_start++;
        }
        return ans;
    }
}