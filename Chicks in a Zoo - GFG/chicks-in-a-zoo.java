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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        long[] dp = new long[N + 1];
        long[] ctb = new long[N + 1];
        dp[1] = 1;
        ctb[1] = 1;
        
        for(int i = 2; i < N+1; i++){
            long deadChicks = 0;
            if(i - 6 > 0){
                deadChicks = ctb[i - 6];
            }
            long currChicks = dp[i-1] - deadChicks;
            ctb[i] = currChicks*2;
            dp[i] = currChicks*3;
        }
        
        return dp[N];
    }
}