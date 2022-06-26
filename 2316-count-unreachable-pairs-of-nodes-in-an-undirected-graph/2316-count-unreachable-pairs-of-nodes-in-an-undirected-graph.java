class Solution {
    long viistedVertices = 0;
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(edges, n);
        
        boolean[] visited = new boolean[n];
        
        long ans = 0;
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            if(!visited[currentVertex]){
                viistedVertices = 0;
                reachableNodes(adj, currentVertex, visited);
                ans += (long)(viistedVertices * (n - viistedVertices));                
            }
        }
        
        return ans/2;
    }
    
    private void reachableNodes(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited){
        
        visited[currentVertex] = true;
        viistedVertices++;
        
        for(int currentNeigh : adj.get(currentVertex)){
            if(!visited[currentNeigh]){
                reachableNodes(adj, currentNeigh, visited);
            }
        }
        
        return;
    }
    
//     private long count(HashSet<Integer> memo, int currentVertex, int n){
//         long ans = 0;
//         for(int i = currentVertex + 1; i < n; i++){
//             if(!memo.contains(i)){
//                 ans++;
//             }
//         }
        
//         return ans;
//     }
    
    private ArrayList<ArrayList<Integer>> constructGraph(int[][] edges, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] currEdge : edges){
            int a = currEdge[0];
            int b = currEdge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        return adj;
    }
}