// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] memo = new int[N+1][W+1];
        
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        
        return unboundedKnapsack(N, W, val, wt, memo);
    }
    
    static int unboundedKnapsack(int N, int W, int[] val, int[] wt, int[][] memo){
        if(W == 0 || N == 0){
            return 0;
        }
        
        
        
        if(memo[N][W] != -1){
            return memo[N][W];
        }
        
        if(wt[N-1] > W){
            return unboundedKnapsack(N - 1, W, val, wt, memo);
        }
        
        int withTaking = val[N-1] + unboundedKnapsack(N, W - wt[N-1], val, wt, memo);
        
        int withoutTaking = unboundedKnapsack(N - 1, W, val, wt, memo);
        
        memo[N][W]  =  Math.max(withTaking, withoutTaking);
        
        return Math.max(withTaking, withoutTaking);
    }
}