class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        
        for(int i = 0; i < k+1; i++){
            
            int[] temp = Arrays.copyOf(costs, n);
            
            for(int[] edge : edges){
                int source = edge[0];
                int dest = edge[1];
                int cost = edge[2];
                
                if(costs[source] != Integer.MAX_VALUE){
                    temp[dest] = Math.min(temp[dest], costs[source] + cost);
                }
            }
            
            costs = temp;
        }
        
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
    
}