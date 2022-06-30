class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = constructAdj(edges, n);
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        
        while(!q.isEmpty()){
            int currentVertex = q.remove();
            visited[currentVertex] = true;
            
            for(int currentNeigh : adj.get(currentVertex)){
                if(!visited[currentNeigh]){
                    q.add(currentNeigh);
                }
            }
        }
        
        return visited[destination];
        
    }
    
    private ArrayList<ArrayList<Integer>> constructAdj(int[][] edges, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] currentEdge : edges){
            int a = currentEdge[0];
            int b = currentEdge[1];
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        return adj;
    }
}