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
        
        int nextCol = col + grid[row][col];
        if(nextCol < 0 || nextCol == grid[0].length || grid[row][col] != grid[row][nextCol]) return -1;
        
        return findColumn(grid, row+1, nextCol);
    }
    
}