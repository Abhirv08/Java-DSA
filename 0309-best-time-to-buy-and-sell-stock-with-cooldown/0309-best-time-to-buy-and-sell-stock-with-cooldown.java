class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();
        return maxProfit(prices, 0, 0, map);
    }
    
    static int maxProfit(int[] prices, int i, int flag, HashMap<String, Integer> map){
        if(i >= prices.length) return 0;
        
        String key = i + ":" + flag;
        if(map.containsKey(key)) return map.get(key);
        
        if(flag == 0){   // have to buy
            int ifBought = -prices[i] + maxProfit(prices, i + 1, 1, map);
            int ifNotBought = maxProfit(prices, i + 1, 0, map);
            
            map.put(key, Math.max(ifBought, ifNotBought));
            
            return map.get(key);
        }// have to sell
        int ifSold = prices[i] + maxProfit(prices, i + 2, 0, map);
        int ifNotSold = maxProfit(prices, i + 1, 1, map);
        
        map.put(key, Math.max(ifSold, ifNotSold));
        return map.get(key);
    }
}