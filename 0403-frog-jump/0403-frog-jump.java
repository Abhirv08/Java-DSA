class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1] - stones[0] > 1) return false;
        int[][] dp = new int[n][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return canCross(n, stones, 1, 1, dp);
    }
    
    private boolean canCross(int n, int[] stones, int idx, int k, int[][] dp){
        if(idx == n-1) return true;
        if(dp[idx][k] != -1) return dp[idx][k] == 1;
        boolean ans = false;
        int i = idx+1;
        while(i < n && stones[i] - stones[idx] <= k+1){
            if(stones[i] - stones[idx] >= k-1) ans = ans || canCross(n, stones, i, stones[i] - stones[idx], dp);
            i++;
        }
        
        if(ans) dp[idx][k] = 1;
        else dp[idx][k] = 0;
         
        return ans;
    }
}