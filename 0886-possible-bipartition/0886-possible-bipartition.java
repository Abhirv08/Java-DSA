class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] dislike: dislikes){
            int a = dislike[0];
            int b = dislike[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        
        for(int i = 1; i < n + 1; i++){
            if(colors[i] == -1){
                if(!bfs(colors, i, adj)) return false;
            }
        }
        
        return true;
    }
    
    boolean bfs(int[] colors, int src, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        colors[src] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();            
            
            for(int neigh: adj.get(node)){
                if(colors[neigh] == colors[node]){
                    return false;
                }
                if(colors[neigh] == -1){
                    colors[neigh] = 1 - colors[node];
                    q.add(neigh);
                }
            }
        }
        
        return true;
    }
}