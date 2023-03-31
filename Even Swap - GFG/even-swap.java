//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
	    Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
		int acq = 0, rel = 0;
		
		while(acq < n){
		    while(acq < n-1 && (arr[acq] + arr[acq+1])%2 == 0){
		        acq++;
		    }
		    acq++;
		    //System.out.println(rel + ":" + acq);
		    Arrays.sort(nums, rel, acq, Collections.reverseOrder());
		    rel = acq;
		}
		
		int[] ans = new int[n];
		for(int i = 0; i < n; i++){
		    ans[i] = nums[i];
		}
		
		return ans;
	}
}