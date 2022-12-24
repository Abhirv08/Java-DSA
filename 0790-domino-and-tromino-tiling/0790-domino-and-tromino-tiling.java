class Solution {
    public int numTilings(int n) {
        long[] dp = new long[n+1];
        
        //dp[i] = 2*dp[i-1] + dp[i-3];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            if(i - 3 < 0){
                dp[i] = (2*dp[i-1])%1000000007;
            }else{
                dp[i] = (2*dp[i-1])%1000000007 + dp[i - 3]%1000000007;
            }
        }
        
        return (int)(dp[n]%1000000007);
    }
}