class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] grid = new String[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = ".";
            }
        }
        nQueens(grid, 0, n, ans);
        return ans;
    }
    
    private void nQueens(String[][] grid, int currRow, int n, List<List<String>> ans){
        if(currRow == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String s = "";
                for(int j = 0; j < n; j++){
                    s += grid[i][j];
                }
                temp.add(s);
            }
            ans.add(temp);
            return ;
        }
        
    for(int col = 0; col < n; col++){
        if(isValid(grid, currRow, col, n)){
            grid[currRow][col] = "Q";
        
            nQueens(grid, currRow+1, n, ans);           
        
            grid[currRow][col] = ".";
        }
    }    
    return ;
}

private boolean isValid(String[][] grid, int currRow, int currCol, int n){
    // For Row and Column
    for(int i = 0; i < n; i++){
        if(grid[currRow][i].equals("Q")) return false;
        
        if(grid[i][currCol].equals("Q")) return false;
    }
    
    // for left side Diagonal
    int row = currRow;
    int col = currCol;
    while(row >= 0 && col >= 0){
        if(grid[row][col].equals("Q")) return false;
        row--; col--;
    }
    // for Right Diagonal
    row = currRow;
    col = currCol;
    while(row >= 0 && col < n){
        if(grid[row][col].equals("Q")) return false;
        row--; col++;
    }
    return true;
}
}
    