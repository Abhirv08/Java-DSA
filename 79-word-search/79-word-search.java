class Solution {
    public boolean exist(char[][] board, String word) {
        for(int currentRow = 0; currentRow < board.length; currentRow++){
            for(int currentCol = 0; currentCol < board[0].length; currentCol++){
                if(board[currentRow][currentCol] == word.charAt(0) && help(board, word, currentRow, currentCol, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean help(char[][] board, String word, int currentRow, int currentCol, int index){
        if(index >= word.length()){
            return true;
        }
        
        if(currentRow < 0 || currentRow >= board.length || currentCol < 0 || currentCol >= board[0].length || board[currentRow][currentCol] != word.charAt(index)){
            return false;
        }       
        
        
        char ch = word.charAt(index);
        
        board[currentRow][currentCol] = '0';
            
        boolean found = help(board, word, currentRow - 1, currentCol, index + 1);
        found = found || help(board, word, currentRow + 1, currentCol, index + 1);
        found = found || help(board, word, currentRow, currentCol - 1, index + 1);
        found = found || help(board, word, currentRow, currentCol + 1, index + 1);
            
        board[currentRow][currentCol] = ch;
                   
        
        
       return found;
    }
}