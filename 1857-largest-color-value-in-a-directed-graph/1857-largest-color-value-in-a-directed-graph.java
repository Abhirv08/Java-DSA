class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = buildGraph(n, edges);
        
        int[] indegree = new int[n];
        for(int[] edge: edges){
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        
        int ans = 0, nodeSeen = 0;
        int[][] count = new int[n][26];
        while(!q.isEmpty()){
            int node = q.poll();
            ans = Math.max(ans, ++count[node][colors.charAt(node) - 'a']);
            nodeSeen++;
            
            for(int neigh: adj.get(node)){
                for(int i = 0; i < 26; i++){
                    count[neigh][i] = Math.max(count[neigh][i], count[node][i]);
                }
                
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }
        
        return nodeSeen < n ? -1 : ans;
    }
    
    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        return adj;
    }
}