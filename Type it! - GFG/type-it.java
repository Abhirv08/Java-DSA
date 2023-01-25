//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
        int n = s.length();
        int longestRepeated = 1;
        for(int i = 1; i < n; i++){
            int temp = 0, j = i + 1;
            while(j < n && temp <= i && s.charAt(temp) == s.charAt(j)){
                j++;
                temp++;
            }
            longestRepeated = Math.max(longestRepeated, temp);
        }
        // System.out.println(longestRepeated);
        return n - longestRepeated + 1;
    }
}