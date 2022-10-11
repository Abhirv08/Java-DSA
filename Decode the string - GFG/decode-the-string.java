//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        Stack<String> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                st.push(s.substring(i, i+1));
            }else{
                StringBuilder temp = new StringBuilder();

                while(!st.isEmpty() && !st.peek().equals("[")){
                    temp.insert(0, st.pop());
                }

                if(!st.isEmpty()){
                    st.pop();
                }

                int count = 0;
                int digits = 0;
                while (!st.isEmpty() && isDigit(st.peek())){
                    count += (int) (Integer.parseInt(st.pop()) * Math.pow(10, digits));
                    digits++;
                }

                StringBuilder suffix = new StringBuilder();
                while(count-- > 0){
                    suffix.append(temp);
                }

                st.push(suffix.toString());
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }

    static boolean isDigit(String s){
        switch(s){
            case "0": return true;
            case "1": return true;
            case "2": return true;
            case "3": return true;
            case "4": return true;
            case "5": return true;
            case "6": return true;
            case "7": return true;
            case "8": return true;
            case "9": return true;
            default: return false;
        }
    }
}