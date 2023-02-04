//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        int[]dp = new int[n+1];
        
        // for(int i = 0; i < n; i++){
        //     dp[i][0] = -1;
        // }
        
        Arrays.fill(dp, -1);
        
        return maxSum(arr, 0, dp);
    }
    
    static int maxSum(int[] arr, int idx, int[] dp){
        if(idx >= arr.length){
            return 0;
        }
        
        if(dp[idx] != -1) return dp[idx];
        
        int notTake = maxSum(arr, idx+1, dp);
        int take = arr[idx] + maxSum(arr, idx+2, dp);
        
        return dp[idx] = Math.max(notTake, take);
    }
}