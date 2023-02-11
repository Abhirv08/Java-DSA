class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: redEdges){
            adj.get(edge[0]).add(new int[]{edge[1], 0}); // 0 -> Red
        }
        
        for(int[] edge: blueEdges){
            adj.get(edge[0]).add(new int[]{edge[1], 1}); // 1 -> Blue
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        ans[0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, -1});
        boolean[][] visit = new boolean[n][2];
        visit[0][0] = true; visit[0][1] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int steps = curr[1];
            int prevColor = curr[2];
            
            for(int[] neigh: adj.get(node)){
                int neighbour = neigh[0];
                int color = neigh[1];
                
                if(!visit[neighbour][color] && color != prevColor){
                    q.add(new int[]{neighbour, steps + 1, color});
                    visit[neighbour][color] = true;
                    if(ans[neighbour] == -1) ans[neighbour] = steps + 1;
                }
            }
        }
        
        return ans;
    }
}