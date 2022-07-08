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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution{
    public int minDifference(int arr[], int n){ 
	    int range = 0;
	    for(int num : arr){
	        range += num;
	    }
	    
	    boolean[][] memo = new boolean[n+1][range+1];
	    
	    for(int i = 0; i < n+1; i++){
	        memo[i][0] = true;
	    }
	    
	    for(int i = 1; i < n + 1; i++){
	        for(int j = 1; j < range+1; j++){
	            if(arr[i-1] <= j){
	                memo[i][j] = memo[i-1][j-arr[i-1]] || memo[i-1][j];
	            }else{
	                memo[i][j] = memo[i-1][j];
	            }
	        }
	    }
	    
	    int ans = Integer.MAX_VALUE;
	    
	    for(int i = 0; i <= range/2; i++){
	        if(memo[n][i]){
	            ans = Math.min(ans, range - 2*i);
	        }
	    }
	    
	    return ans;
	} 
}
