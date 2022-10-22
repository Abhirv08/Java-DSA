//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = 100000000;
    static int fillingBucket(int N) {
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        
        return fillingBucket(N, dp);
    }
    
    static int fillingBucket(int N, int[] dp){
        if(N < 0) return 0;
        if(N == 0) return 1;
        
        if(dp[N] != -1) return dp[N];
        
        int ans = fillingBucket(N - 1, dp)%mod;
        
        ans = ans%mod + fillingBucket(N - 2, dp)%mod;
        
        return dp[N] = ans%mod;
    }
    
};