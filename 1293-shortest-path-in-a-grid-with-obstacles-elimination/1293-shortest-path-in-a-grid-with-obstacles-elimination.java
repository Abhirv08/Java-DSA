class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][][] vis = new boolean[m][n][k+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k});
        int steps = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                
                if(curr[0] == m - 1 && curr[1] == n - 1) return steps;
                
                for(int[] d: dir){
                    int newR = curr[0] + d[0];
                    int newC = curr[1] + d[1];
                    int obs = curr[2];
                    
                    if(newR >= 0 && newR < m && newC >= 0 && newC < n){
                        if(grid[newR][newC] == 0 && !vis[newR][newC][obs]){
                            q.add(new int[]{newR, newC, obs});
                            vis[newR][newC][obs] = true;
                        }else if(grid[newR][newC] == 1 && obs > 0 && !vis[newR][newC][obs - 1]){
                            q.add(new int[]{newR, newC, obs - 1});
                            vis[newR][newC][obs - 1] = true;
                        }
                    }
                    
                }               
            }
            steps++;
        }
        return -1;
    }
}