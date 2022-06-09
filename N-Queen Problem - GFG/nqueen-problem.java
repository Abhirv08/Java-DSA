// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        String[][] grid = new String[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = ".";
            }
        }
        nQueens(grid, 0, n, ans);
        return ans;
        
    }
    
    static void nQueens(String[][] grid, int currRow, int n, ArrayList<ArrayList<Integer>> ans){
        if(currRow == n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j].equals("Q")){
                        temp.add(j+1);
                    }
                }
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

static boolean isValid(String[][] grid, int currRow, int currCol, int n){
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