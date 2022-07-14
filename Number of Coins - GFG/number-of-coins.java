// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V){ 
	    int[][] memo = new int[M + 1][V+1];
	    
	    for(int[] arr : memo){
	        Arrays.fill(arr, -1);
	    }
	    
	    int ans = minCoins(coins, M, V, memo);
	    return ans == (int) 1e7 ? -1 : ans;
	} 
	
	private int minCoins(int[] coins, int M, int V, int[][] memo){
	    if(V == 0){
	        return 0;
	    }
	    
	    if(M == 0){
	        return (int)1e7;
	    }
	    
	    if(memo[M][V] != -1){
	        return memo[M][V];
	    }
	    
	    if(coins[M-1] > V){
	        return minCoins(coins, M - 1, V, memo);
	    }
	    
	    int withTaken = 1 + minCoins(coins, M, V - coins[M-1], memo);
	    
	    int withoutTaken = minCoins(coins, M - 1, V, memo);
	    
	    memo[M][V] = Math.min(withTaken, withoutTaken);
	    
	    return Math.min(withTaken, withoutTaken);
	}
}