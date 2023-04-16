class Solution {
    long mod = (long) 1e9+7;
    long[][] dp;
    public int numWays(String[] words, String target) {
        int n = words[0].length();

        int[][] mat = new int[26][n];

        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                mat[ch - 'a'][i]++;
            }
        }
        
        int[][] ps = new int[26][n];
        
        for(int r = 0; r < 26; r++){
            for(int c = n-1; c >= 0; c--){
                if(c == n - 1){
                    ps[r][c] = mat[r][c];
                }else{
                    ps[r][c] = ps[r][c+1] + mat[r][c];
                }
            }
        }
        
        dp = new long[n][target.length()];
        
        for(long[] arr: dp) Arrays.fill(arr, -1);
        
        return (int) (findWays(ps, n, 0, target, 0)%mod);
    }
    
    private long findWays(int[][] ps, int n, int idx, String target, int tgtIdx){
        char ch = target.charAt(tgtIdx);
        if(idx == n) return 0;
        
        if(tgtIdx == target.length() - 1){
            return ps[ch - 'a'][idx];
        }
        
        if(dp[idx][tgtIdx] != -1) return dp[idx][tgtIdx];
        
        int freq = ps[ch-'a'][idx] - (idx+1 < n ? ps[ch-'a'][idx+1] : 0);
        long ways = (freq*findWays(ps, n, idx+1, target, tgtIdx+1)%mod)%mod;
        ways += findWays(ps, n, idx+1, target, tgtIdx)%mod;
        
        return dp[idx][tgtIdx] = ways%mod;
    }
}