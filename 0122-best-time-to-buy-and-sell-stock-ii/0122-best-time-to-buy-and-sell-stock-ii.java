class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                total += prices[i] - min;
                min = prices[i];
            }
        }
        
        return total;
    }
}