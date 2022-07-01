class Solution {
    public boolean isBipartite(int[][] adj) {
        int v = adj.length;
        int[] visited = new int[v];
        Arrays.fill(visited, -1);
        
        for(int currentVertex = 0; currentVertex < v; currentVertex++){
            if(visited[currentVertex] == -1){
                if(!dfs(adj, currentVertex, 0, visited)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int[][] adj, int currentVertex, int color, int[] visited){  
        visited[currentVertex] = color;

        for(int neighbour : adj[currentVertex]){
            if(visited[neighbour] == -1){
                if(!dfs(adj, neighbour, color == 0 ? 1 : 0, visited)){
                    return false;
                }
            }else if (visited[neighbour] == color){
                return false;
            }
        }

        return true;
    }
    
}