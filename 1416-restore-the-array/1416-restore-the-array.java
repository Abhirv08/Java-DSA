class Solution {    
    public int numberOfArrays(String s, int k) {
        long mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n+1];
        
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
            long num = 0, count = 0;
            for(int j = i; j < n; j++){
                char ch = s.charAt(j);
                num = num*10 + (ch - '0');
                if(num >= 1 && num <= k){
                    count += dp[j+1]%mod;
                    count %= mod;
                }else if(num > k || num < 1) break;
            }

            dp[i] = count%mod;
        }
        
        
        return (int) dp[0];
    }
}