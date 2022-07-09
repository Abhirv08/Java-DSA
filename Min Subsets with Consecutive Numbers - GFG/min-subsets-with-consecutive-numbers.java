// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numofsubset(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static int numofsubset(int arr[], int n)
    {
        if(n == 1) return 1;
        
        Arrays.sort(arr);
        
        int count = 0;
        
        for(int i = 1; i < n; i++){
            if(arr[i-1] + 1 != arr[i]){
                count++;
            }
            if(i == n-1){
                count++;
            }
            
        }
        
        return count;
    }
}