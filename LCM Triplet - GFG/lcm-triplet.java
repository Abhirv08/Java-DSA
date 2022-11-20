//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.lcmTriplets(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long lcmTriplets(long N) {
        if(N < 3){
            return N;
        }
        
        if(N%2 == 1){
            return N*(N-1)*(N-2);
        }
        
        if(N%3 == 0){
            return Math.max(N*(N-1)*(N-2)/2, (N-1)*(N-2)*(N-3));
        }
        
        return N*(N-1)*(N-3);
    }
}