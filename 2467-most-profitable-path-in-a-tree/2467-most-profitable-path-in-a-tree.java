class Solution {
    int ans, maxAns;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] parent = new int[n];
        int[] dist = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int level = 0;
        boolean[] vis = new boolean[n];
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int vertex = q.poll();
                dist[vertex] = level;
                vis[vertex] = true;
                
                for(int neigh: adj.get(vertex)){
                    if(!vis[neigh]){
                        parent[neigh] = vertex;
                        q.add(neigh);
                    }
                }
            }
            level++;
        }
        
         //System.out.println(Arrays.toString(parent));
         //System.out.println(Arrays.toString(dist));
        
        int curr = bob;
        int currDist = 0;
        
        while(curr != 0){
            if(currDist < dist[curr]){
                amount[curr] = 0;
            }else if(currDist == dist[curr]){
                amount[curr] /= 2;
            }
            curr = parent[curr];
            currDist++;
        }
        
        //System.out.println(Arrays.toString(amount));
        vis = new boolean[n];
        ans = 0; maxAns = Integer.MIN_VALUE;
        dfs(amount, 0, vis, adj);
        
        return maxAns;
    }
    
    private void dfs(int[] amount, int vertex, boolean[] vis, List<List<Integer>> adj){
        vis[vertex] = true;
        ans += amount[vertex];
        int trav = 0;
        
        for(int neigh: adj.get(vertex)){
            if(!vis[neigh]){
                trav++;
                dfs(amount, neigh, vis, adj);
            }
        }
        
        if(trav == 0){
            maxAns = Math.max(maxAns, ans);
        }
        
        ans -= amount[vertex];
    }
    
}