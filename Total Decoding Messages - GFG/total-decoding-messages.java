//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        int mod = 1000000007;
        if(str.charAt(0) == '0') return 0;
        int[] dp = new int[str.length()+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i < str.length()+1; i++){
            int curr = str.charAt(i-1) - '0';
            int prev = str.charAt(i-2) - '0';
            if(curr > 0) dp[i] = dp[i-1];
            if(prev == 1 || (prev == 2 && curr < 7)){
                dp[i] += dp[i-2];
                dp[i] %= mod;
            }
        }
        
        return dp[str.length()];
    }
}