class Solution {
       private boolean isSafe(char[][] board, int row, int col, char t){
        
        for(int i = 0; i<board[0].length; i++){
            
            //check in column if target is present
            if(board[row][i] == t) return false;
            
             //check in row if target is present
            if(board[i][col] == t) return false;
            
        }
        
        //check in grid if target is present
        int startRowOfGrid = (row/3) * 3;
        int startColOfGrid = (col/3) * 3;
        
        for(int i = startRowOfGrid; i < startRowOfGrid + 3; i++){
            for(int j = startColOfGrid; j < startColOfGrid + 3; j++){
                if(board[i][j] == t) return false;
            }
        }
        
        return true;
    }
    
    private boolean helper(char[][] board, int row, int col){
        
        if(row == board.length) return true;
        
		// for the next recursive call we will pass this 
        int newRow = 0;
        int newCol = 0;
        
        if(col == board[0].length-1){
            //go to next row
            newRow = row + 1;
            newCol = 0;
        }else{
            //go one cell further
            newRow = row;
            newCol = col + 1;
        }
        
        if(board[row][col] == '.'){
            //empty cell
            for(char value = '1'; value <= '9'; value++){
                if(isSafe(board, row, col, value)){
                    board[row][col] = value;
                    if(helper(board, newRow, newCol)){
                        //if the placed value is correct
                        return true;
                    }else{
                        //backtrack
                        board[row][col] = '.';
                    }
                }
            }
        }
        else{
            //already filled
            if(helper(board, newRow, newCol)) return true;
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    } 
//     public void solveSudoku(char[][] board) {
//         sudokuSolver(board, 0, 0);
//         return;
//     }
    
//     private boolean sudokuSolver(char[][] board, int currRow, int currCol){
//         if(currRow == board.length){
//             return true;
//         }
//         int nextRow;
//         int nextCol;
//         if(currCol == board.length-1){
//             nextRow = currRow + 1;
//             nextCol = 0;
//         }else{
//             nextCol = currCol + 1;
//             nextRow = currRow;
//         }
//         if(board[currRow][currCol] != '.')
//             return sudokuSolver(board, nextRow, nextCol);
        
        
//         for(char i = '1'; i <= '9'; i++){
//                 if(isValid(board, currRow, currCol, i))
//                     board[currRow][currCol] = i;
                
//                 if(sudokuSolver(board, nextRow, nextRow))
//                     return true;
                
//                 board[currRow][currCol] = '.';             
//             }        
//         return false;
//     }
    
//     private boolean isValid(char[][] board, int currRow, int currCol, char ch){
        
//         for(int i = 0; i < 9; i++){
//             // For Row 
//             if(board[currRow][i] == ch){
//                 return false;
//             }
//             // For column
//             if(board[i][currCol] == ch){
//                 return false;
//             }
//         }
        
//         // For semi Grid
//         int rowStart = 3 * (currRow / 3);
//         int colStart = 3 * (currCol / 3);
        
//         for(int i = 0; i < rowStart + 3; i++){
//             for(int j = 0; j < colStart + 3; j++){
//                 if(board[i][j] == ch){
//                     return false;
//                 }
//             }
//         }
        
//         return true;
//     }

    
}