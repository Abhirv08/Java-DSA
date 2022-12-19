class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<List<Integer>> adj = buildGraph(edges, n);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        boolean[] vis = new boolean[n];
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            
            for(int neigh: adj.get(node)){
                q.add(neigh);
            }
        }
        
        return vis[dest];
    }
    
    private List<List<Integer>> buildGraph(int[][] edges, int n){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        
        return adj;
    }
}