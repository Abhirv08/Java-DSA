class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    sinkIsland(grid, i, j);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    private void sinkIsland(char[][] grid, int row, int col){
        if( row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0'){
            return ;
        }
        
        grid[row][col] = '0';
        
        sinkIsland(grid, row - 1, col);
        sinkIsland(grid, row, col + 1);
        sinkIsland(grid, row + 1, col);
        sinkIsland(grid, row, col - 1); 
        
        
    }
    
}