class Graph {
    List<List<int[]>> adj;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{node1, 0});
        
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[node1] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            
            if(node == node2) return costs[node];
            
            List<int[]> neigh = adj.get(node);
            for(int[] currNeigh: neigh){
                if(cost + currNeigh[1] < costs[currNeigh[0]]){
                    costs[currNeigh[0]] = cost + currNeigh[1];
                    pq.add(new int[] {currNeigh[0], cost + currNeigh[1]});
                }
            }
        }
        
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */