class Solution {

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> adj = buildGraph(n, edges);
        
        boolean[] vis = new boolean[n];
        
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                long count = dfs(adj, i, vis);
                ans += (n - count)*count;
            }
        }
        
        return ans/2;
    }
    
    private long dfs(List<List<Integer>> adj, int vertex, boolean[] vis){
        vis[vertex] = true;
        
        long count = 1;
        for(int neigh: adj.get(vertex)){
            if(!vis[neigh]){
                count += dfs(adj, neigh, vis);
            }
        }
        
        return count;
    }
    
    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return adj;
    }
}