//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair{
    int row, col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source[0], source[1]));
        int size = 1;
        int level = 0;
        
        while(true){
            while(size > 0){
                Pair p = q.remove();
                int row = p.row;
                int col = p.col;
                size--;
                
                if(row == destination[0] && col == destination[1]){
                    return level;
                }
                
                if(row - 1 >= 0 && grid[row - 1][col] == 1){
                    q.add(new Pair(row - 1, col));
                    grid[row - 1][col] = 0;
                }
            
                if(col + 1 < grid[0].length && grid[row][col + 1] == 1){
                    q.add(new Pair(row, col + 1));
                    grid[row][col + 1] = 0;
                }
            
                if(row + 1 < grid.length && grid[row + 1][col] == 1){
                    q.add(new Pair(row + 1, col));
                    grid[row + 1][col] = 0;
                }
            
                if(col - 1 >= 0 && grid[row][col - 1] == 1){
                    q.add(new Pair(row, col - 1));
                    grid[row][col - 1] = 0;
                }
            }
            
            size = q.size();
            if(size == 0){
                return -1;
            }
            level++;
        }
        
    }
}
