class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int count = 0;
        for(int r = 1; r < n-1; r++){
            for(int c = 1; c < m-1; c++){
                if(grid[r][c] == 0 && !vis[r][c] && isClosed(grid, r, c, vis)){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isClosed(int[][] grid, int r, int c, boolean[][] vis){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        if(vis[r][c] || grid[r][c] == 1) return true;
        
        vis[r][c] = true;
        
        boolean up = isClosed(grid, r-1, c, vis);
        boolean right = isClosed(grid, r, c+1, vis);
        boolean down = isClosed(grid, r+1, c, vis);
        boolean left = isClosed(grid, r, c-1, vis);
        
        return up && right && down && left;
    }
}