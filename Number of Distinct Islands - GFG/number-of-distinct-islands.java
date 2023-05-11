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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    HashSet<List<String>> set;
    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == 1 && !vis[r][c]){
                    List<String> list = new ArrayList<>();
                    countDistinct(n, m, grid, new int[]{r, c}, new int[]{r, c}, vis, list);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
    
    void countDistinct(int n, int m, int[][] grid, int[] cur, int[] base, boolean[][] vis, List<String> list){
        vis[cur[0]][cur[1]] = true;
        
        String s = '(' + (cur[0] - base[0]) + "," + (cur[1] - base[1]) + ')'; 
        list.add(s);
        for(int[] d: dirs){
            int nr = cur[0] + d[0];
            int nc = cur[1] + d[1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                countDistinct(n, m, grid, new int[]{nr, nc}, base, vis, list);
            }
        }
        
    }
}
