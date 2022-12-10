//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int k) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            while(!st.isEmpty() && num < st.peek() && k > 0){
                st.pop();
                k--;
            }
            st.push(num);
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        while(ans.length() > 0 && k-- > 0){
            ans.deleteCharAt(0);
        }
        
        ans = ans.reverse();
        
        while(ans.length() > 0 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        
        if(ans.length() == 0) return "0";
        
        return ans.toString();
    }
}