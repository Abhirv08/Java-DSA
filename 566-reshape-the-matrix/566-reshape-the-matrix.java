class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
//         if(r==mat.length && c == mat[0].length) return mat;
//         int[][] ans = new int[r][c];
//         int ans_row = 0, ans_col = 0;
//         for(int row = 0; row < mat.length; row++){
//             for(int col = 0; col < mat[0].length; col++){
                
//                     if(ans_col <= c-1){
//                         ans[ans_row][ans_col] = mat[row][col];
//                         ans_col++;
//                     }else{
//                         ans_row++;
//                     }
//                 if(ans_col == c) ans_col = 0;
               
//             }
//         }
//         return ans;
        
          int m = mat.length, n = mat[0].length;
  if (r * c != m * n)
  return mat;

   int[][] reshaped = new int[r][c];
   for (int i = 0; i < r * c; i++)
   reshaped[i/c][i%c] = mat[i/n][i%n];

   return reshaped;
    }
}