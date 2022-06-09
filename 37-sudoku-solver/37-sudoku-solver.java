class Solution {    
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
        return;
    }
    
    private boolean sudokuSolver(char[][] board, int currRow, int currCol){
        if(currRow == board.length){
            return true;
        }
        int nextRow;
        int nextCol;
        if(currCol == board.length-1){
            nextRow = currRow + 1;
            nextCol = 0;
        }else{
            nextCol = currCol + 1;
            nextRow = currRow;
        }
        if(board[currRow][currCol] != '.' ){
            return sudokuSolver(board, nextRow, nextCol);
        }
        
        for(char i = '1'; i <= '9'; i++){
                if(isValid(board, currRow, currCol, i)){
                    board[currRow][currCol] = i;
                
                    if(sudokuSolver(board, nextRow, nextCol))
                        return true;
                
                    board[currRow][currCol] = '.';            
                } 
            }        
        return false;
    }
    
    private boolean isValid(char[][] board, int currRow, int currCol, char ch){
        
        for(int i = 0; i < 9; i++){
            // For Row 
            if(board[currRow][i] == ch){
                return false;
            }
            // For column
            if(board[i][currCol] == ch){
                return false;
            }
        }
        
        // For semi Grid
        int rowStart = 3 * (currRow / 3);
        int colStart = 3 * (currCol / 3);
        
        for(int i = rowStart; i <= rowStart + 2; i++){
            for(int j = colStart; j <= colStart + 2; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        
        return true;
    }

    
}