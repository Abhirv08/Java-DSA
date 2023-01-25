class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        bfs(edges, dist1, node1);
        bfs(edges, dist2, node2);
        
        
        
        int ans = n, minDist = Integer.MAX_VALUE;
        for(int i = 0 ; i < n; i++){
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE ){
                int distancefromnode1 = dist1[i];
                int distancefromnode2 = dist2[i];
                if(minDist > Math.max(distancefromnode1, distancefromnode2)){
                    minDist = Math.max(distancefromnode1, distancefromnode2);
                    ans = i;
                }
            }
        }
        
        return ans == n ? -1 : ans;
    }
    
    private void bfs(int[] edges, int[] dist, int node){
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        dist[node] = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int curr = q.poll();
                int neigh = edges[curr];
                if(neigh != -1 && dist[neigh] == Integer.MAX_VALUE){
                    dist[neigh] = 1 + dist[curr];
                    q.add(neigh);
                }
            }
        }
    }
}