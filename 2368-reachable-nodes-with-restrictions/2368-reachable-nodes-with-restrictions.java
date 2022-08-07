class Solution {
    int ans;
    int nodesVisited;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(edges, n);        

        
        boolean[] visited = new boolean[n];
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : restricted){
            set.add(num);
        }
        
        ans = 0;
        
        nodesVisited = 0;
        if(!set.contains(0)){
            dfs(adj, 0, visited, set);
        }
        ans = Math.max(ans, nodesVisited);
        
        
        return ans;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int currNode, boolean[] visited, HashSet<Integer> set){
        if(visited[currNode]){
            return ;
        }
        
        visited[currNode] = true;
        nodesVisited++;
        
        for(int neigh : adj.get(currNode)){
            if(!set.contains(neigh)){
                dfs(adj, neigh, visited, set);
            }
        }
        
        return;
    }
    
    
    private ArrayList<ArrayList<Integer>> constructGraph(int[][] edges, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        
        return adj;
    }
}