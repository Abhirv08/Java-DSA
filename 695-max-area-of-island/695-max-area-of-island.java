class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max_area = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    max_area = Math.max(max_area, areaOfIsland(grid, i, j, visited));
                }
            }
        }
        return max_area;
    }
    
    private int areaOfIsland(int[][] grid, int sr, int sc, boolean[][] visited){
        int sum = 1;
        if(sr-1 >= 0 && grid[sr-1][sc] == 1 && visited[sr-1][sc] == false){
            visited[sr-1][sc] = true;
            sum += areaOfIsland(grid, sr-1, sc, visited);
        }
        if(sc+1 < grid[0].length && grid[sr][sc+1] == 1&& visited[sr][sc+1] == false){
            visited[sr][sc+1] = true;
            sum += areaOfIsland(grid, sr, sc + 1, visited);
        }
        if(sr+1 < grid.length && grid[sr+1][sc] == 1 && visited[sr+1][sc] == false){
            visited[sr+1][sc] = true;
            sum += areaOfIsland(grid, sr+1, sc, visited);
        }
        if(sc-1 >= 0 && grid[sr][sc-1] == 1 && visited[sr][sc-1] == false){
            visited[sr][sc-1] = true;
            sum += areaOfIsland(grid, sr, sc-1, visited);
        }
        return sum;
    }
}