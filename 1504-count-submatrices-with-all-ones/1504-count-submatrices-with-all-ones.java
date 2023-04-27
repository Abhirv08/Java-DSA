class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int ans = 0;
        int[][] total = new int[m][n];
        
        for(int r = 0; r < m; r++){
            total[r][n-1] = mat[r][n-1];
            for(int c = n-2; c >= 0; c--){
                if(mat[r][c] == 1){
                    total[r][c] = total[r][c+1] + 1;
                }
            }
        }
        
        int count = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int minWidth = total[r][c];                
                for(int d = r; d < m; d++){
                    if(total[d][c] == 0) break;
                    minWidth = Math.min(minWidth, total[d][c]);
                    count += minWidth;
                }
            }
        }
        
        return count;
    }
}