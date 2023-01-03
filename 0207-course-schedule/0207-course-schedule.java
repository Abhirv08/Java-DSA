class Solution {
    public boolean canFinish(int v, int[][] edges ) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(v, edges);   

        int[] inDegree = new int[v];
        for(int i = 0; i < v; i++){
            for(int child: adj.get(i)){
                inDegree[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }        
        boolean[] visited = new boolean[v];
        int visitedVertex = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node]) continue;
            visited[node] = true;
            visitedVertex++;
            for(int child: adj.get(node)){
                inDegree[child]--;
                if(inDegree[child] == 0){
                    q.add(child);
                }
            }
        }
        
        
        return visitedVertex == v ? true : false;
    }
    
     private ArrayList<ArrayList<Integer>> constructGraph(int v, int[][] prerequisites ){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edges : prerequisites){
            int neighbour = edges[0];
            int source = edges[1];
            
            graph.get(source).add(neighbour);
        }
        return graph;
    }
}