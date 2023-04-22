class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] a: dp) Arrays.fill(a, -1);
        
        return findMinIns(s, 0, n - 1);
    }
    
    private int findMinIns(String s, int i, int j){
        if(i >= j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)) {
            return findMinIns(s, i+1, j-1);
        }
        
        int left = findMinIns(s, i+1, j);
        int right = findMinIns(s, i, j-1);
        
        return dp[i][j] = 1 + Math.min(left, right);
    }
}