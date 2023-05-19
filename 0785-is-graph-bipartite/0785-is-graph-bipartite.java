class Pair{
    int vertex;
    int color;
    
    Pair(int vertex, int color){
        this.vertex = vertex;
        this.color = color;
    }
}

class Solution {
    public boolean isBipartite(int[][] adj) {
        int v = adj.length;
        int[] visited = new int[v];
        Arrays.fill(visited, -1);
        
        for(int currentVertex = 0; currentVertex < v; currentVertex++){
            if(visited[currentVertex] == -1){
                if(!isPossible(adj, 0, currentVertex, visited)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isPossible(int[][] adj, int currentColor, int currentVertex, int[] visited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(currentVertex, currentColor));
        
        while(!q.isEmpty()){
            Pair currentPair = q.remove();
            int currVertex = currentPair.vertex;
            int currColor = currentPair.color;
            
            visited[currVertex] = currColor;
            for(int currentNeigh : adj[currVertex]){
                if(visited[currentNeigh] == -1){
                    q.add(new Pair(currentNeigh, 1 - currColor));
                }else if(visited[currentNeigh] == currColor){
                    return false;
                }
            }  
        }
        
        return true;
    }
}