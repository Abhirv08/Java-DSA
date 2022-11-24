class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    ans = ans || find(board, i, j, word, 0);
                }
            }
        }
        
        return ans;
    }
    
    private boolean find(char[][] board, int row, int col, String word, int idx){
        if(idx == word.length()) return true;
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(idx)){
            return false;
        }
        
        board[row][col] = '.';
        
        boolean ans = find(board, row - 1, col, word, idx+1) || find(board, row, col + 1, word, idx+1) || find(board, row + 1, col, word, idx+1) || find(board, row, col - 1, word, idx+1);
        
        board[row][col] = word.charAt(idx);
        
        return ans;
    }
}