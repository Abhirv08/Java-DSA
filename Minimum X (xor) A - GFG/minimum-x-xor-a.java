// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minVal(a, b));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int bitsA = Integer.bitCount(a);
        int bitsB = Integer.bitCount(b);
        int diff = Math.abs(bitsA - bitsB);
        
        if(bitsA > bitsB){
            while(diff > 0){
                a = a & (a - 1);
                diff--;
            }
        }else if(bitsA < bitsB){
            while(diff > 0){
                a = a | (a + 1);
                diff--;
            }
        }
        return a;
    }
}