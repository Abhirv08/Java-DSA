class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int l = n-1; l >= 0; l--){
            dp[l][l] = 1;
            for(int r = l+1; r < n; r++){
                if(s.charAt(l) == s.charAt(r)){
                    dp[l][r] = 2 + dp[l+1][r-1];
                }else{
                    dp[l][r] = Math.max(dp[l+1][r],  dp[l][r-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    private int longestPalindrome(String s, int l, int r, int[][] dp){
        if(l == r){
            return 1;
        }
        
        if(l > r){
            return 0;
        }
        
        if(dp[l][r] != -1) return dp[l][r];
        
        if(s.charAt(l) == s.charAt(r)){
            return dp[l][r] = 2 + longestPalindrome(s, l+1, r-1, dp);
        }
        
        return dp[l][r] = Math.max(longestPalindrome(s, l+1, r, dp),  longestPalindrome(s, l, r-1, dp));
    }
}