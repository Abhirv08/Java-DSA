class Solution {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int currentRow = 0; currentRow < m; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                if( grid[currentRow][currentCol] == 0 && (currentRow == 0 || currentRow == m-1 || currentCol == 0 || currentCol == n-1)){
                    sinkIsland(grid, currentRow, currentCol, m, n);
                }
            }
        }
        
        for(int currentRow = 1; currentRow < m-1; currentRow++){
            for(int currentCol = 1; currentCol < n-1; currentCol++){
                if( grid[currentRow][currentCol] == 0){
                    sinkIsland(grid, currentRow, currentCol, m, n);
                    ans++;
                }
            }
        }
        
        for(int[] g : grid){
            System.out.println(Arrays.toString(g));
        }
        
        return ans;
    }
    
    private void sinkIsland(int[][] grid, int currentRow, int currentCol, int m, int n){
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == 1){
            return;
        }
        
        grid[currentRow][currentCol] = 1;
        
        sinkIsland(grid, currentRow - 1, currentCol, m, n);
        sinkIsland(grid, currentRow + 1, currentCol, m, n);
        sinkIsland(grid, currentRow, currentCol - 1, m, n);
        sinkIsland(grid, currentRow, currentCol + 1, m, n);
        
        return;
        
    }
    
}