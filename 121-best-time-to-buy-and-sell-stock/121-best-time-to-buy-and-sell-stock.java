class Solution {
    public int maxProfit(int[] prices) {
        
        int[] arr = new int[prices.length];
        arr[arr.length-1] = prices[prices.length-1];
        for(int i = prices.length-2; i >= 0; i--){
            arr[i] = Math.max(arr[i+1], prices[i] );
        }
        System.out.println( Arrays.toString(arr) );
        int max_profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(arr[i] - prices[i] > max_profit){
                max_profit = arr[i] - prices[i];
            }
        }
        return max_profit;
    }    
    
}