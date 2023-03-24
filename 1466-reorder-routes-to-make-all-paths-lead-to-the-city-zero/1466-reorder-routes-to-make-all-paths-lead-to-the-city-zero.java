class Solution {
    int count;
    public int minReorder(int n, int[][] connections) {
        count = 0;
        List<List<int[]>> adj = buildGraph(n, connections);
        dfs(adj, 0, -1);
        return count;
    }
    
    private void dfs(List<List<int[]>> adj, int vertex, int parent){
        for(int[] neigh: adj.get(vertex)){
            int child = neigh[0];
            int sign = neigh[1];
            
            if(child != parent){
                count += sign;
                dfs(adj, child, vertex);
            }
        }
    }
    
    private List<List<int[]>> buildGraph(int n, int[][] edges){
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{edge[1], 1});  // 1 for original path
            adj.get(edge[1]).add(new int[]{edge[0], 0});  // 1 for artificial path
        }
        
        return adj;
    }
}