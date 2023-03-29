class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        int[][] dp = new int[n][n];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return maximize(s, 0, 0, dp);
    }
    
    private int maximize(int[] s, int idx, int count, int[][] dp){
        if(idx == s.length) return 0;
        
        if(dp[idx][count] != -1) return dp[idx][count];
        // if chef decided to prepare
        int make = (count+1)*s[idx] + maximize(s, idx+1, count+1, dp);
        int notMake = maximize(s, idx+1, count, dp);
        
        return dp[idx][count] = Math.max(make, notMake);
    }
}