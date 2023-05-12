class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return maxPoints(questions, 0);
    }
    
    private long maxPoints(int[][] q, int idx){
        if(idx >= q.length) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        long ifTaken = q[idx][0] + maxPoints(q, idx + q[idx][1] + 1);
        long taken = maxPoints(q, idx + 1);
        
        return dp[idx] = Math.max(ifTaken ,taken);
    }
}