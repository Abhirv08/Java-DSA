class Solution {
    public int numDistinct(String s, String t) {
        int s_len = s.length(), t_len = t.length();
        
        int[][] dp = new int[s_len + 1][t_len + 1];
        
//         for(int i = 1; i <= s_len; i++){
//             for(int j = 1; j <= t_len; j++){
//                 if(s.charAt(i - 1) == t.charAt(j - 1)){
//                     dp[i][j] += dp[i - 1][j - 1];
//                 }

//                 dp[i][j] += dp[i - 1][j];
//             }
//         }
        
//         return dp[s_len][t_len];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return countSubSeq(s, s_len-1, t, t_len-1, dp);
    }
    
    private int countSubSeq(String s, int i1, String t, int i2, int[][] dp){
        if(i2 == -1){
            return 1;
        }
        
        if(i1 == -1){
            return 0;
        }
        
        if(dp[i1+1][i2+1] != -1) return dp[i1+1][i2+1];
        
        int take = 0;
        if(s.charAt(i1) == t.charAt(i2)){
            take = countSubSeq(s, i1-1, t, i2-1, dp);
        }
        
        int notTake = countSubSeq(s, i1-1, t, i2, dp);
        
        return dp[i1+1][i2+1] = take + notTake;
    }
}