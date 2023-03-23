class Solution {
    public int numDistinct(String s, String t) {
        int s_len = s.length(), t_len = t.length();
        
        int[][] dp = new int[s_len + 1][t_len + 1];
        
        for(int i = 0; i <= s_len; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= s_len; i++){
            for(int j = 1; j <= t_len; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }

                dp[i][j] += dp[i - 1][j];
            }
        }
        
        return dp[s_len][t_len];
    }
}