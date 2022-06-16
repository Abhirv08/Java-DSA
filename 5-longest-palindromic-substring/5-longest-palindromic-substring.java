class Solution {
    public String longestPalindrome(String s) {
      int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] max = new int[2];
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; i++, j++){
                if(g == 0) dp[i][j] = true;
                else if(g == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                
                if(dp[i][j] && max[1] - max[0] < j - i){
                    max[0] = i;
                    max[1] = j;
                }
            }
        }
        
        
        return s.substring(max[0], max[1] + 1);
        
        
    }
}