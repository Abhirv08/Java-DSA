class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {src, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        while(k-- >= 0 && !q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] curr = q.poll();
                
                for(int[] neigh: adj.get(curr[0])){
                    if(curr[1] + neigh[1] < dist[neigh[0]]){
                        dist[neigh[0]] = curr[1] + neigh[1];
                        q.add(new int[]{neigh[0], curr[1] + neigh[1]});
                    }
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}