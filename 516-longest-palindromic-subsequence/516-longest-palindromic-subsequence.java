class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder();
        
        for(int i = s.length() - 1; i >= 0; i--){
            str.append(s.charAt(i));
        }
        
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
    }
}