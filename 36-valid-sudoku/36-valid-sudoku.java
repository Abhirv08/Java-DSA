class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet seen = new HashSet();
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] != '.'){
                    if(!seen.add("row"+row+board[row][col]) || !seen.add("col"+col+board[row][col])){
                    return false;
                }
                if(!seen.add("Box" + (row/3)*3+col/3 + board[row][col])){
                    return false;
                }
                }
            }
        }
        return true;
    }
}