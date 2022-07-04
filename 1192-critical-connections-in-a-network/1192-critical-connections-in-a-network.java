class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] discovery_time = new int[n];
        Arrays.fill(discovery_time, -1);
        
        int[] low_time = new int[n];
        Arrays.fill(low_time, -1);
        
        List<List<Integer>> adj = constructGraph(connections, n);
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            if(discovery_time[currentVertex] == -1){
                dfs(adj, currentVertex, new int[1], -1, ans, discovery_time, low_time);
            }
        }
        
        
        return ans;
    }
    
    private void dfs(List<List<Integer>> adj, int currentVertex, int[] currentTime, int currentParent, List<List<Integer>> ans, int[] discovery_time, int[] low_time){
        
        discovery_time[currentVertex] = currentTime[0];
        low_time[currentVertex] = currentTime[0];
        currentTime[0]++;
        
        for(int currentNeigh : adj.get(currentVertex)){
            
            if(currentNeigh == currentParent){
                continue;               
            }
            
            if(discovery_time[currentNeigh] != -1){
                low_time[currentVertex] = Math.min(low_time[currentVertex], discovery_time[currentNeigh]);
                continue;
            }
            
            dfs(adj, currentNeigh, currentTime, currentVertex, ans, discovery_time, low_time);
            
            low_time[currentVertex] = Math.min(low_time[currentVertex], low_time[currentNeigh]);
            
            if(discovery_time[currentVertex] < low_time[currentNeigh]){                
                ans.add(Arrays.asList(currentVertex, currentNeigh));
            }
        } 
    }
    
    private List<List<Integer>> constructGraph(List<List<Integer>> connections, int n){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> edge : connections){
            int a = edge.get(0);
            int b = edge.get(1);
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        return adj;
    }
}