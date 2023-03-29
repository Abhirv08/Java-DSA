class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        int[][] dp = new int[n+1][n+2];
        
        for(int i = n-1; i >= 0; i--){
            for(int c = 1; c <= n; c++){
                int make = c*s[i] + dp[i+1][c+1];
                int notMake = dp[i+1][c];

                dp[i][c] = Math.max(make, notMake);
            }
        }
        
        return dp[0][1];
    }
}