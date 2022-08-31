class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        
        for (int col = 0; col< n; col++){
            dfs(0, col, m, n, p, heights[0][col], heights);
            dfs(m-1, col,m, n, a, heights[m-1][col], heights);
        }
        for (int row = 0; row<m; row++){
            dfs(row, 0,m, n, p, heights[row][0], heights);
            dfs(row, n-1,m, n, a, heights[row][n-1], heights);   
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (p[i][j] && a[i][j])
                    result.add(Arrays.asList(i,j));  
            }
        return result;
    }
    private void dfs(int row, int col, int m, int n, boolean[][] visited, int prevHeight, int[][] heights){
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || prevHeight > heights[row][col])
            return;
        visited[row][col]= true;
        dfs(row+1, col, m, n, visited, heights[row][col], heights);
        dfs(row-1, col, m, n, visited, heights[row][col], heights);
        dfs(row, col+1, m, n, visited, heights[row][col], heights);
        dfs(row, col-1, m, n, visited, heights[row][col], heights);
        
    }
}