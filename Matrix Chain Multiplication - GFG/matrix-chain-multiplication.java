//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp ;
    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int[N][N];
        
        for(int i = N-1; i > 0; i--){
            for(int j = i+1; j < N; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int val = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, val);
                }
                dp[i][j] = (min == Integer.MAX_VALUE ? 0 : min);
            }
        }
        
        // return helper(arr, 1, N-1);
        return dp[1][N-1];
    }
}