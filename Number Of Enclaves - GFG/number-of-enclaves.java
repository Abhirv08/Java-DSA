//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int ones = 0;
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ones++;
                    if((i == 0 || i == n-1 || j == 0 || j == m-1) && !vis[i][j]){
                        int count = dfs(n, m, grid, i, j, vis);
                        ones -= count;
                    }
                }
            }
        }
        
        return ones;
    }
    
    private int dfs(int n, int m, int[][] grid, int r, int c, boolean[][] vis){
        vis[r][c] = true;
        
        int count = 1;
        for(int[] d: dirs){
            int nr = r + d[0];
            int nc = c + d[1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                count += dfs(n, m, grid, nr, nc, vis);
            }
        }
        
        return count;
    }
}