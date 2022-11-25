//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long[][] dp;
    long count(long n)
    {
        long ans = 0;
        String s = new StringBuilder(Long.toString(n, 2)).toString();
        int m = s.length();
        int ones = 0;
        
        for(int i = 0; i < m; i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
        }
        dp = new long[64][64];
        
        for(long[] d: dp) Arrays.fill(d, -1L);
        
        for(int i = 0; i < m; i++){
            if(s.charAt(i) == '1'){
                long count = (long)findPermutations(m - 1 - i, ones);
                ans += count;
                ones--;
            }
        }
        
        return ans;
    }
    
    long findPermutations(int n, int r){
        if(n == 0 || n < r) return 0;
        if(r == 0 || n == r){
            return 1;
        }
        
        if(dp[n][r] != -1) return dp[n][r];
        
        
        return dp[n][r] = findPermutations(n-1, r-1) + findPermutations(n - 1, r);
    }
}