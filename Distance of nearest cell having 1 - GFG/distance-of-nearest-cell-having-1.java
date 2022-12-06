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
        int n = grid.length; 
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        for(int[] a: ans){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] loc = q.poll();
                int cr = loc[0];
                int cc = loc[1];
                
                ans[cr][cc] = Math.min(steps, ans[cr][cc]);
                
                for(int[] d: dirs){
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        
        return ans;
    }
}