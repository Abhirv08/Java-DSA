class Pair implements Comparable<Pair>{
    int vertex, cost;
    
    Pair(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    
    public int compareTo(Pair p){
        return this.cost - p.cost;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        constructGraph(points, adj, V);
        
        int ans = 0;
        boolean[] visited = new boolean[V];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()){
            Pair currentPair = pq.remove();
            int vertex = currentPair.vertex;
            int cost = currentPair.cost;
            
            if(visited[vertex])
                continue;
            
            visited[vertex] = true;
            ans += cost;
            
            for(ArrayList<Integer> currentNeigh : adj.get(vertex)){
                if(!visited[currentNeigh.get(0)]){
                    pq.add(new Pair(currentNeigh.get(0), currentNeigh.get(1) ));
                }
            }
        }
        
        return ans;
    }
    
    private void constructGraph(int[][] graph, ArrayList<ArrayList<ArrayList<Integer>>> adj, int V){
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            int[] p1 = graph[i];
            for(int j = 0; j < graph.length; j++){
                int[] p2 = graph[j];
                int cost = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                if(i != j){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(j); temp.add(cost);
                    adj.get(i).add(temp);
                }
            }
        }
        
    }
}