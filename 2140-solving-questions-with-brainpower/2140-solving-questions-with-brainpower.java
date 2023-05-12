class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        
        long[] dp = new long[n+1];
        
        for(int idx = n-1; idx >= 0; idx--){
            long ifTaken = q[idx][0];
            if(idx + q[idx][1] + 1 < n){
                ifTaken += dp[idx + q[idx][1] + 1];
            }
            long taken = dp[idx + 1];
        
            dp[idx] = Math.max(ifTaken ,taken);
        }
            
        return dp[0];
    }
}