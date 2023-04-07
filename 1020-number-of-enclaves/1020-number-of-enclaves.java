class Solution {
    int count;
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        int cells = 0;
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n - 1; j++){
                count = 0;
                if(!vis[i][j] && grid[i][j] == 1 && dfs(grid, i, j, vis)){
                    cells += count;
                }
            }
        }
        
        return cells;
    }
    
    private boolean dfs(int[][] grid, int r, int c, boolean[][] vis){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        if(grid[r][c] == 0 || vis[r][c]) return true;
        
        vis[r][c] = true;
        count++;
        boolean up = dfs(grid, r-1, c, vis);
        boolean right = dfs(grid, r, c+1, vis);
        boolean down = dfs(grid, r+1, c, vis);
        boolean left = dfs(grid, r, c-1, vis);
        
        return up && right && down && left;
    }
}