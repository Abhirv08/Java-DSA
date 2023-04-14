class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        int len = longestPalindrome(s, 0, n-1, dp);
        
       
        
        return len;
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