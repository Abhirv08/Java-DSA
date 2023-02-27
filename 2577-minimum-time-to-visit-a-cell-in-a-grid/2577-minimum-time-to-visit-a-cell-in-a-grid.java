class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length, n = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[m][n];
        pq.add(new int[]{0, 0, 0});
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!pq.isEmpty()){
            int[] pos = pq.poll();
            int r = pos[0];
            int c = pos[1];
            int time = pos[2];

            if(r == m - 1 && c == n - 1){
                return time;
            }
            
            if(vis[r][c]) continue;
            
            vis[r][c] = true;
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]){
                    if(grid[nr][nc] <= time + 1){
                        pq.add(new int[]{nr, nc, time + 1});
                    }else{
                        int diff = grid[nr][nc] - time;
                        if(diff%2 == 0){
                            pq.add(new int[]{nr, nc, grid[nr][nc] + 1});
                        }else{
                            pq.add(new int[]{nr, nc, grid[nr][nc]});
                        }
                    }
                }
            }    
        }
        
        return -1;
    }
}