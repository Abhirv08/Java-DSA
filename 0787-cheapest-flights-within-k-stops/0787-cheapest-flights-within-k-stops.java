class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        
        for(int i = 0; i < k + 1; i++){
            int[] temp = Arrays.copyOf(costs, n);
            for(int[] flight: flights){
                int s = flight[0];
                int d = flight[1];
                int cost = flight[2];
                
                if(costs[s] != Integer.MAX_VALUE){
                    temp[d] = Math.min(temp[d], costs[s]+cost);
                }
            }
            costs = temp;
        }
        
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}