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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        String a = new StringBuilder(A).reverse().toString();
        String b = new StringBuilder(B).reverse().toString();
        
        StringBuilder ans = new StringBuilder();
        
        int i = 0, j = 0, carry = 0;
        while(i < a.length() && j < b.length()){
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(j) - '0';
            
            int sum = num1 + num2 + carry;
            ans.append(sum&1);
            carry = sum >> 1;
            i++;
            j++;
        }
        
        while(i < a.length()){
            int num1 = a.charAt(i) - '0';
            
            int sum = num1 + carry;
            ans.append(sum&1);
            carry = sum >> 1;
            i++;
        }
        
        while(j < b.length()){
            int num2 = b.charAt(j) - '0';
            
            int sum = num2 + carry;
            ans.append(sum&1);
            carry = sum >> 1;
            j++;
        }
        
        if(carry > 0) ans.append(carry);
        ans = ans.reverse();
        
        while(ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        
        return ans.toString();
    }
}