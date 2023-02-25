class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int max = prices[n-1];
        int ans = 0;
        for(int i = n - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, max - prices[i]);
        }
        
        return ans;
    }
}