class Solution {
    public int countOrders(int n) {
        int mod = 1000000007;
        long ans = 1;
        for(int i = 1; i <=n; i++){
            ans = ans*i;
            ans = ans*(2*i-1);
            ans %= mod;
        }
        
        return (int)ans;
    }
}