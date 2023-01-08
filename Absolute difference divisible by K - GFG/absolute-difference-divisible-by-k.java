//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			String S[] = read.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(S[i]);
			int k = Integer.parseInt(read.readLine());

			Solution ob = new Solution();
			System.out.println(ob.countPairs(n, arr, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static long countPairs(int n, int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; i++){
		    map.put(arr[i]%k, map.getOrDefault(arr[i]%k, 0) + 1);
		}
		
		long ans = 0;
		
		for(int key: map.keySet()){
		    ans += combination(map.get(key), 2);
		}
		
		return ans;
	}
	
	static long combination(long n, long r){
	    if(r == 1) return n;
	    if(r == n) return 1;
	    
	    return (n * combination(n - 1, r - 1))/r;
	}
}