class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int currentRow = 0; currentRow < m; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                if(grid[currentRow][currentCol] == '1'){
                    sinkIsland(grid, currentRow, currentCol, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void sinkIsland(char[][] grid, int currentRow, int currentCol, int m, int n){
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == '0'){
            return;
        }
        
        grid[currentRow][currentCol] = '0';
        
        sinkIsland(grid, currentRow - 1, currentCol, m, n);
        sinkIsland(grid, currentRow + 1, currentCol, m, n);
        sinkIsland(grid, currentRow, currentCol - 1, m, n);
        sinkIsland(grid, currentRow, currentCol + 1, m, n);
        
        return;
    }
}