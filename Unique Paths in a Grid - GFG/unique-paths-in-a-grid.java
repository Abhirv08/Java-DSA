//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long mod = 1000000007;
    static int[][] dirs = {{0, 1}, {1, 0}};
    static int uniquePaths(int n, int m, int[][] grid) {
        boolean[][] vis = new boolean[n][m];
        long[][] dp = new long[n][m];
        for(long[] r: dp){
            Arrays.fill(r, -1l);
        }
        
        if(grid[0][0] == 0) return 0;
        
        long ans = dfs(grid, n, m, 0, 0, dp);
        
        return (int) (ans%mod);
    }
    
    static long dfs(int[][] grid, int n, int m, int cr, int cc, long[][] dp){
    
        if(cr == n - 1 && cc == m - 1) return 1l;
        
        if(dp[cr][cc] != -1) return dp[cr][cc];
        
        long ans = 0;
        for(int[] dir: dirs){
            int nr = cr + dir[0];
            int nc = cc + dir[1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                ans = (ans%mod + dfs(grid, n, m, nr, nc, dp)%mod)%mod;
            }
        }
        
        return dp[cr][cc] = ans%mod;
    }
};