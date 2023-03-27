//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        int[][][] dp = new int[N + 1][K + 1][N+1];
        
        for(int[][] m: dp) {
            for(int[] r: m){
                Arrays.fill(r, -1);
            }
        }
        
        return countWays(N, K, dp, -1);
    }
    
    private int countWays(int N, int k, int[][][] dp, int prev){
        if(k == 1){
            if(N >= prev) return 1;
            else return 0;
        }
        
        if(N == 0 || k == 0) return 0;
        
        if(dp[N][k][prev+1] != -1) return dp[N][k][prev+1];
        
        int ways = 0;
        for(int i = 1; i <= N; i++){
            if(i >= prev){
                ways += countWays(N - i, k - 1, dp, i);
            }
        }
        
        return dp[N][k][prev+1] = ways;
    }
    
}