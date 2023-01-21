//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int setBitsInb = Integer.bitCount(b);
        int setBitsIna = Integer.bitCount(a);
        
        if(setBitsInb == setBitsIna) return a;
        else if(setBitsInb > setBitsIna){
            int extra = setBitsInb - setBitsIna;
            int temp = a, i = 0;
            while(extra > 0){
                if((temp&1) == 0){
                    a |= (1<<i);
                    extra--;
                }
                i++;
                temp >>= 1;
            }
        }else{
            int extra = setBitsIna - setBitsInb;
            int temp = a, i = 0;
            while(extra > 0){
                if((temp&1) == 1){
                    a ^= (1<<i);
                    extra--;
                }
                i++;
                temp >>= 1;
            }
        }
        
        return a;
    }
}