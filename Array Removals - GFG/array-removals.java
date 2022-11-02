//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        Arrays.sort(arr);
        
        int[][] dp = new int[n][n];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        return minRemoval(arr, 0, n-1, k, dp);
    }
    
    int minRemoval(int[] arr, int left, int right, int k, int[][] dp){
        if(left > right) return 0;
        
        if(arr[right] - arr[left] <= k){
            return left + (arr.length - 1 - right);
        }
        
        if(dp[left][right] != -1){
            return dp[left][right];
        }
            // if i remove first
        int removeFirst = minRemoval(arr, left + 1, right, k, dp);
            // if i removes last
        int removeLast = minRemoval(arr, left, right - 1, k, dp);
            
        return dp[left][right] = Math.min(removeFirst, removeLast);
    }
    
}