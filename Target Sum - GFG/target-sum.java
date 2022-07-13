// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        return findTarget(A, N, target, 0);
    }
    
    static int findTarget(int[] A, int n, int target, int currVal){
        if(n == 0){
            if(target == currVal){
                return 1;
            }else{
                return 0;
            }
        }
        
        
        return findTarget(A, n-1, target, currVal + A[n-1] ) + findTarget(A, n-1, target, currVal - A[n-1] );
    }
    
};