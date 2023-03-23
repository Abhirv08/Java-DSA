class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj = buildGraph(connections, n);
        
        int isolated = 0;
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                isolated++;
                dfs(adj, i, vis);
            }
        }
        
        if(connections.length < n - 1 && isolated > 0) return -1;
        
        return isolated - 1;
    }
    
    private void dfs(List<List<Integer>> adj, int vertex, boolean[] vis){
        vis[vertex] = true;
        
        for(int neigh: adj.get(vertex)){
            if(!vis[neigh]){
                dfs(adj, neigh, vis);
            }
        }
    }
    
    private List<List<Integer>> buildGraph(int[][] connections, int n){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] connection: connections){
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }
        
        return adj;
    }
}