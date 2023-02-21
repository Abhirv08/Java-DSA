//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int steps = -1;
		boolean[][] vis = new boolean[N][M];
		vis[x-1][y-1] = true;
		while(!q.isEmpty()){
		    int sz = q.size();
		    steps++;
		    while(sz-- > 0){
		        int[] pos = q.poll();
		        for(int[] dir: dirs){
		            int nr = pos[0] + dir[0];
		            int nc = pos[1] + dir[1];
		            
		            if(nr >= 1 && nc >= 1 && nr <= N && nc <= M && !vis[nr-1][nc-1]){
		                q.add(new int[] {nr, nc});
		                vis[nr-1][nc-1] = true;
		            }
		        }
		    }
		}
		
		return steps;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends