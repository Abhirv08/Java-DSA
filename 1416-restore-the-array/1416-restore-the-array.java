class Solution {
    long mod = 1000000007;
    long[] dp;
    public int numberOfArrays(String s, int k) {
        dp = new long[s.length()];
        Arrays.fill(dp, -1);
        return (int) (formedNumbers(s, k, 0)%mod);
    }
    
    private long formedNumbers(String s, int k, int idx){
        if(idx == s.length()) return 1;
        
        if(dp[idx] != -1) return dp[idx];
        
        long num = 0, count = 0;
        for(int i = idx; i < s.length(); i++){
            char ch = s.charAt(i);
            num = num*10 + (ch - '0');
            if(num >= 1 && num <= k){
                count += formedNumbers(s, k, i+1)%mod;
                count %= mod;
            }else if(num > k || num < 1) break;
        }
        
        return dp[idx] = count;
    }
}