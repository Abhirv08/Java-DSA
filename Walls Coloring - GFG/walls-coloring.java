//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int[][] dp;
	int minCost(int [][] colors, int N){
        dp = new int[N][4];
        for(int[] row: dp) Arrays.fill(row, -1);
        
        return minCost(colors, N, 0, -1);
    }
    
    int minCost(int[][] colors, int N, int row, int prev){
        if(row == N) return 0;
        
        if(dp[row][prev+1] != -1) return dp[row][prev+1];
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            if(i != prev){
                int nextCost = colors[row][i] + minCost(colors, N, row + 1, i);
                ans = Math.min(ans, nextCost);
            }
        }
        
        return dp[row][prev+1] = ans;
    }
}