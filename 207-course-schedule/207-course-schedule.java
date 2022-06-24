class Solution {
    public boolean canFinish(int v, int[][] adj) {
       int[] inDegree = new int[v];
        
        // find indegree of each courses
        for(int i = 0; i < adj.length; i++){
            inDegree[adj[i][1]]++;
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
            
            for(int i = 0; i < adj.length; i++){
                if(adj[i][0] == currentVertex){
                    inDegree[adj[i][1]]--;
                    if(inDegree[adj[i][1]] == 0){
                        q.add(adj[i][1]);
                    }
                }
            }
        }     
        
        return visitedVertex == v ? true : false;
    }
}