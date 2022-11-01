class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            ans[i] = findColumn(grid, 0, i);
        }
        
        return ans;
    }
    
    private int findColumn(int[][] grid, int row, int col){
        if(row == grid.length) return col;
        
        if(grid[row][col] == 1){
            if(col + 1 < grid[0].length && grid[row][col] == grid[row][col + 1]){
                return findColumn(grid, row + 1, col + 1);
            }
        }else{
            if(col - 1 >= 0 && grid[row][col] == grid[row][col - 1]){
                return findColumn(grid, row + 1, col - 1);
            }
        }
        
        return -1;
    }
    
}