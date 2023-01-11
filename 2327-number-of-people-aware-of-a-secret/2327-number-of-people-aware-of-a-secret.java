class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        long[] dp = new long[n+1];
        
        dp[1] = 1;
        
        long peopleSharingSecret = 0;
        for(int i = 2; i < n+1; i++){
            long newPeople = dp[Math.max(i-delay, 0)];
            long peopleForgetting = dp[Math.max(i-forget, 0)];;
            
            peopleSharingSecret = (peopleSharingSecret + newPeople - peopleForgetting + mod)%mod;
            dp[i] = peopleSharingSecret;
        }
        
        long ans = 0;
        
        for(int i = n - forget + 1; i < n+1; i++){
            ans = (ans + dp[i])%mod;
        }
        
        return (int)(ans%mod);
    }
}