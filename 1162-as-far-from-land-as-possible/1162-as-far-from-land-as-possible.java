class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        
        int ans = -1;
        
        int[][] vis = new int[n][n];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                vis[i][j] = grid[i][j];
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int dist = -1;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                
                for(int[] dir: dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if(nr >= 0 && nc >= 0 && nr < n && nc < n && vis[nr][nc] == 0){
                        vis[nr][nc] = 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }
        
        return dist == 0 ? -1 : dist;
    }
}