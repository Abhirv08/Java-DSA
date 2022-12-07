class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = buildTree(roads, n);
        
        int ans = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, Integer.MAX_VALUE});
        boolean[] vis = new boolean[n+1];
        vis[1] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] path = q.poll();
                int node = path[0];
                int cost = path[1];
                
                vis[node] = true;
                ans = Math.min(ans, cost);
                
                for(int[] neigh: adj.get(node)){
                    if(!vis[neigh[0]]){
                        q.add(new int[]{neigh[0], Math.min(cost, neigh[1])});
                    }
                }
            }
        }
        
        return ans;
    }
    
    private ArrayList<ArrayList<int[]>> buildTree(int[][] roads, int n){
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] road: roads){
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        return adj;
    }
}