class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        for(int i1 = 1; i1 < n1 + 1; i1++){
            for(int i2 = 1; i2 < n2 + 1; i2++){
                if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }else{
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }
            }
        }
        
        return dp[n1][n2];
    }
    
    
}