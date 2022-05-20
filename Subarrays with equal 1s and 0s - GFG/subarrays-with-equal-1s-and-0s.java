// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> memo = new HashMap<>();
        int psum = 0;
        int ans = 0;
        memo.put(0,1);
        for(int i  = 0; i < n; i++){
            
            psum += (arr[i] == 1 ? 1 : -1);
            if(memo.containsKey(psum)){
                ans += memo.get(psum);
                memo.put(psum, memo.get(psum)+1);
            }else{
                memo.put(psum, 1);
            }
        }
        return ans;
    }
}


