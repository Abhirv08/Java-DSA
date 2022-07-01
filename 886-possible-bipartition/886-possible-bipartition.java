class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(dislikes, n);
        
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            if(visited[currentVertex] == -1){
                if(!isDivisibleIntoTwo(adj, currentVertex, 0, visited)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isDivisibleIntoTwo(ArrayList<ArrayList<Integer>> adj, int currentVertex, int currentColor, int[] visited){
        if(visited[currentVertex] != -1){
            return visited[currentVertex] == currentColor;
        }
        
        visited[currentVertex] = currentColor;
        
        for(int currentNeigh : adj.get(currentVertex)){
            if(!isDivisibleIntoTwo(adj, currentNeigh, 1 - currentColor, visited)){
                return false;
            }
        }
        
        return true;
    }
    
    private ArrayList<ArrayList<Integer>> constructGraph(int[][] dislikes, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] dislike : dislikes){
            int a = dislike[0] - 1;
            int b = dislike[1] - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        return adj;
    }
}