class Solution {
    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;
        if(d > n) return -1;
        
        int[][] dp = new int[d+1][n];
        for(int[] r : dp) Arrays.fill(r, -1);
        
                
        return dfs(jd, d, 0, dp);
    }
    
    private int dfs(int[] jd, int d, int idx, int[][] dp){
        if(d == 1){
            int max = 0;
            while(idx < jd.length) max = Math.max(max, jd[idx++]);
            
            return max;
        }
        
        if(dp[d][idx] != -1) return dp[d][idx];
        
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int i = idx; i < jd.length - d + 1; i++){
            max = Math.max(max, jd[i]);
            res = Math.min(res, max + dfs(jd, d - 1, i + 1, dp));
        }
        
        return dp[d][idx] = res;
    } 
    
}