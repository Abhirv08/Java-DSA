class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[] maxInFut = new int[n];
        maxInFut[n-1] = prices[n-1];
        for(int i = n - 2; i >= 0; i--){
            maxInFut[i] = Math.max(prices[i], maxInFut[i+1]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, maxInFut[i] - prices[i]);
        }
        
        return ans;
    }
}