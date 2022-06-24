class Solution {
    public boolean canFinish(int v, int[][] prerequisites ) {
                ArrayList<ArrayList<Integer>> adj = constructGraph(v, prerequisites);
        int[] inDegree = new int[v];
        
        // find indegree of each courses
        for(int i = 0; i < v; i++){
            for(int course : adj.get(i)){
                inDegree[course]++;
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
            int currentVertex = q.poll();
            
            if(visited[currentVertex])
                continue;
            
            visited[currentVertex] = true;
            
            visitedVertex++;
            
            for(int neighbour : adj.get(currentVertex)){
                inDegree[neighbour]--;
                    if(inDegree[neighbour] == 0){
                        q.add(neighbour);
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
            int destination = edges[0];
            int source = edges[1];
            
            graph.get(source).add(destination);
        }
        return graph;
    }
}