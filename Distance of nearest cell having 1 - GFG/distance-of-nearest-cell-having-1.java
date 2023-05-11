//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        for(int[] r: ans){
            Arrays.fill(r, -1);
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1) {
                    ans[r][c] = 0;
                    q.add(new int[]{r, c, 0});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    int nr = cur[0] + i;
                    int nc = cur[1] + j;
                    int cost = cur[2] + Math.abs(nr - cur[0]) + 
                    Math.abs(nc - cur[1]);
                    
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && (ans[nr][nc] == -1 ||
                    ans[nr][nc] > cost)){
                        ans[nr][nc] = cost;
                        q.add(new int[]{nr, nc, cost});
                    }
                }
            }
            
        }
        
        return ans; 
    }
    
    
}