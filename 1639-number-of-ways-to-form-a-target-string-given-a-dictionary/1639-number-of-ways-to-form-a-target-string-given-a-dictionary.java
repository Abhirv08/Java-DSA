class Solution {
    public int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();
        int mod = 1000000007;
        int[] dp = new int[m+1];
        dp[0] = 1;
        
        int[][] cnt = new int[n][26];
        
        for(String word: words){
            for(int i = 0; i < n; i++){
                char ch = word.charAt(i);
                cnt[i][ch-'a']++;
            }
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = m - 1; j >= 0; j--){
                dp[j+1] += (int) ((long) dp[j]*cnt[i][target.charAt(j) - 'a']%mod);
                dp[j+1] %= mod;
            }
        }
        
        return dp[m];
    }
}