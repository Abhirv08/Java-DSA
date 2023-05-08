class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        int r = 0, c = 0;
        
        while(r < n && c < n){
            ans += mat[r][c];
            r++;
            c++;
        }
        
        r = 0; c = n-1;
        
        while(r < n && c >= 0){
            ans += mat[r][c];
            r++;
            c--;
        }
        
        if(n%2 == 1) ans -= mat[n/2][n/2];
        
        return ans;
    }
}