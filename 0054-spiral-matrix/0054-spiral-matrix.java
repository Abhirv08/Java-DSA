class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer> ();
        int row = matrix.length, col = matrix[0].length;
        int cnt = 0, total = row * col;
        int start_row = 0, start_col = 0;
        int end_row = row - 1, end_col = col - 1;
        while(cnt < total)
        {
            for(int i = start_col; cnt < total && i <= end_col; i++)
            {
                res.add(matrix[start_row][i]);
                cnt++;
            }
            start_row++;
            for(int i = start_row; cnt < total && i <= end_row; i++)
            {
                res.add(matrix[i][end_col]);
                cnt++;
            }
            end_col--;
            for(int i = end_col; cnt < total && i >= start_col; i--)
            {
                res.add(matrix[end_row][i]);
                cnt++;
            }
            end_row--;
            for(int i = end_row; cnt < total && i >= start_row; i--)
            {
                res.add(matrix[i][start_col]);
                cnt++;
            }
            start_col++;
        }
        return res;
    }
}