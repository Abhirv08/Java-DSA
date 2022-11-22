class Solution {
    public int numSquares(int n) {
        int[] psn = new int[101];
        
        for(int i = 1; i < 101; i++){
            psn[i] = i*i;
        }
        
        int[][] dp = new int[n+1][101];
        
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        
        return leastNumbers(psn, 100, n, dp);
    }
    
    private int leastNumbers(int[] psn, int idx, int n, int[][] dp){
        if(n == 0) return 0;
        if(idx == 0 || n < 0) return 100000;
        
        if(dp[n][idx] != -1) return dp[n][idx];
        int ans = Integer.MAX_VALUE;
        if(psn[idx] <= n){
            ans = Math.min(ans, 1 + leastNumbers(psn, idx, n - psn[idx], dp));
        }
        ans = Math.min(ans, leastNumbers(psn, idx - 1, n, dp));
        
        return dp[n][idx] = ans;        
    }
}