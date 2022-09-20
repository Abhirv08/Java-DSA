class Solution {
    public int findLength(int[] a, int[] b) {
        int ans = 0;
        
        int[][] dp = new int[a.length+1][b.length+1];
        
        for(int i = 1; i < a.length+1; i++){
            for(int j = 1; j < b.length+1; j++){
                if(a[i-1] ==b[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans;
    }
}