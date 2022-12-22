//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int maxCoins(int N, int[] arr) {
        
        int[][] dp = new int[N][N];
        
        for(int gap = 0; gap < N; gap++){
            for(int i = 0, j = gap; j < N; i++, j++){
                int max = 0;
                
                for(int k = i; k <= j; k++){
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j? 0 : dp[k+1][j];
                    int val = (i == 0 ? 1 : arr[i-1])*arr[k]*(j == N - 1? 1: arr[j+1]);
                    
                    max = Math.max(max, left+right+val);
                }
                dp[i][j] = max;
            }
        }
      
        return dp[0][N-1];
    }
}
