class Solution {
    public int findLength(int[] a, int[] b) {
        int ans = 0;
        
        int[][] dp = new int[a.length+1][b.length+1];
        
        for(int i = a.length-1; i >= 0; i--){
            for(int j = b.length-1; j>=0; j--){
                if(a[i] ==b[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                    if(dp[i][j] > ans) ans = dp[i][j];
                }
            }
        }
        
        return ans;
    }
}