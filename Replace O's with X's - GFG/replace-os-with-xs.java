//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] fill(int n, int m, char a[][])
    {
        boolean[][] vis = new boolean[n][m];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(r == 0 || r == n-1 || c == 0 || c == m-1){
                    if(a[r][c] == 'O' && !vis[r][c]){
                        dfs(n, m, a, r, c, vis);
                    }
                }
            }
        }
        
        char[][] ans = new char[n][m];
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(!vis[r][c]){
                    ans[r][c] = 'X';
                }else{
                    ans[r][c] = 'O';
                }
            }
        }
        
        return ans;
    }
    
    static void dfs(int n, int m, char a[][], int r, int c, boolean[][] vis){
        
        vis[r][c] = true;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && a[nr][nc] == 'O'){
                dfs(n, m, a, nr, nc, vis);
            }
        }
        
    }
}