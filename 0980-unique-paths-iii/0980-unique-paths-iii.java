class Solution {
    int path;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        path = 0;
        int zeros = 0;
        int[] start = new int[2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    zeros++;
                }else if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        grid[start[0]][start[1]] = -1;
        totalPath(grid, start[0], start[1], zeros, m, n);
        return path;
    }
    
    private void totalPath(int[][] grid, int row, int col, int zeros, int m, int n){
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                if(grid[nr][nc] == 0){
                    grid[nr][nc] = -1;
                    totalPath(grid, nr, nc, zeros-1, m, n);
                    grid[nr][nc] = 0;
                }else if(grid[nr][nc] == 2 && zeros == 0){
                    path++;
                }
            }
        }      
                                                             
        return ;
    }
}