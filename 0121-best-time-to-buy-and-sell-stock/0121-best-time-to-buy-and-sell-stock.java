class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
                max = 0;
            }else{
                max = Math.max(max, prices[i]);
            }
            
            ans = Math.max(ans, max - min);
        }
        
        return ans;
    }
}