class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean c1 = validateRowsAndCols(board);
        boolean c2 = validateSubBoxes(board);
            
        return c1&&c2;
    }
    
    private boolean validateSubBoxes(char[][] board){        
        
        
        boolean ans = true;
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                ans = ans&&validateSubBox(board, row, col);
            }
        }
        
        return ans;
    }
    
    private boolean validateSubBox(char[][] board, int row, int col){
        HashSet<Character> set = new HashSet<>();
        
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(board[i][j] != '.'){
                    if(!set.add(board[i][j])){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean validateRowsAndCols(char[][] board){
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!set.add("row"+i+board[i][j]) || !set.add("col"+j+board[i][j])){
                        return false;
                    }
                    
                }
            }
        }
        
        return true;
    }
}