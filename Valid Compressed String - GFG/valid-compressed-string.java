//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        int i = 0, j = 0;

        while(i < T.length() && j < S.length()){
            if(Character.isDigit(T.charAt(i))){
                int temp = i;
                int num = 0;
                while(temp < T.length() && Character.isDigit(T.charAt(temp))){
                    num = num*10 + (T.charAt(temp) - '0');
                    temp++;
                }
                i = temp;
                j += (num);
            }else{
                if(T.charAt(i) != S.charAt(j)){
                    return 0;
                }
                i++;
                j++;
            }
        }

        if(i == T.length() && j == S.length()) return 1;

        return 0;
    }
}