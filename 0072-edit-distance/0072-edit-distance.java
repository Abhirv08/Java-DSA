class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return findMinOper(word1, m-1, word2, n-1, dp);
    }
    
    private int findMinOper(String w1, int i1, String w2, int i2, int[][] dp){
        if(i2 < 0){
            return i1 + 1;
        }
        
        if(i1 < 0) return i2 + 1;
        
        if(dp[i1+1][i2+1] != -1) return dp[i1+1][i2+1];
        
        if(w1.charAt(i1) == w2.charAt(i2)){
           return dp[i1+1][i2+1] = findMinOper(w1, i1 - 1, w2, i2 - 1, dp);
        }
        
        int insert = findMinOper(w1, i1, w2, i2 - 1, dp);
        int replace = findMinOper(w1, i1 - 1, w2, i2 - 1, dp);
        int delete = findMinOper(w1, i1 - 1, w2, i2, dp);
        
        return dp[i1+1][i2+1] = 1 + Math.min(insert, Math.min(replace, delete));
    }
}