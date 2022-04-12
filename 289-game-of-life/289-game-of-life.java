class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        int i = 0, j = 0;
        while( i < m){
            int countones = 0;
            if(i-1 >=0 && j-1 >= 0){
                if( board[i-1][j-1] > 0) countones++;
            }
            if(i-1 >=0 && j >= 0){
                if( board[i-1][j] > 0) countones++;
            }
            if(i-1 >=0 && j+1 < n){
                if( board[i-1][j+1] > 0) countones++;
            }
            if(i >=0 && j-1 >= 0){
                if( board[i][j-1] > 0) countones++;
            }
            if(i >=0 && j+1 < n){
                if( board[i][j+1] > 0) countones++;
            }
            if(i+1 < m && j-1 >= 0){
                if( board[i+1][j-1] > 0) countones++;
            }
            if(i+1 < m && j >= 0){
                if( board[i+1][j] > 0) countones++;
            }
            if(i+1 < m && j+1 < n){
                if( board[i+1][j+1] > 0) countones++;
            }
            if(countones < 2)  temp[i][j] = 0;
            else if(countones >= 2 && countones <3) temp[i][j] = board[i][j];
            else if(countones == 3) temp[i][j] = 1;
            else if(countones > 3) temp[i][j] = 0;
            if(j < n) j++;
            if(j == n){
                i++;
                j = 0;
            }
        }
        for(int k = 0; k < m; k++){
            for(int l = 0; l < n; l++){
                board[k][l] = temp[k][l];
            }
        }
    }
}