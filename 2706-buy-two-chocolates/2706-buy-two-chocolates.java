class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        
        int diff = money - prices[0] - prices[1];
        
        if(diff < 0) return money;
        
        return diff;
    }
}