//{ Driver Code Starts
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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    
	    int tSum = 0;
	    for(int num: arr){
	        tSum += num;
	    }
	    
	    int[][] dp = new int[n+1][tSum];
	    for(int[] row: dp){
	        Arrays.fill(row, -1);
	    }
	    
	    int ans = minDiff(arr, tSum, 0, 0, dp);
	    return ans == Integer.MAX_VALUE ? tSum : ans;
	} 
	
	private int minDiff(int[] arr, int tSum, int sum, int idx, int[][] dp){
	    if(idx == arr.length){
	        if(sum == tSum || sum == 0){
	            return Integer.MAX_VALUE;
	        }else{
	            return Math.abs(tSum - 2*sum);
	        }
	    }
	    
	    if(dp[idx][sum] != -1){
	        return dp[idx][sum];
	    }
	    
	    // if taken
	    int ifTaken = minDiff(arr, tSum, sum + arr[idx], idx + 1, dp);
	    
	    int ifNotTaken = minDiff(arr, tSum, sum, idx + 1, dp);
	    
	    return dp[idx][sum] = Math.min(ifTaken, ifNotTaken);
	}
}
