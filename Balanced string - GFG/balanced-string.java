//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        int temp = N;
        int sum = 0;
        while(temp > 0){
            sum += temp%10;
            temp /= 10;
        }
        
        StringBuilder ans = new StringBuilder();
        String str = "abcdefghijklmnopqrstuvwxyz";
        while(N >= 26){
            ans.append(str);
            N -= 26;
        }
        
        while(N > 0){
            if(N%2 == 0){
                int firstN = N/2;
                int lastN = 26 - N/2;
                
                ans.append(addLetters(0, firstN));
                
                ans.append(addLetters(lastN, 26));
            }else{
                if(sum%2 == 0){
                    int firstN = (N+1)/2;
                    int lastN = 26 - (N-1)/2;
                    
                    ans.append(addLetters(0, firstN));
                    
                    ans.append(addLetters(lastN, 26));
                }else{
                    int firstN = (N-1)/2;
                    int lastN = 26 - (N+1)/2;
                    
                    ans.append(addLetters(0, firstN));
                    
                    ans.append(addLetters(lastN, 26));
                }
            }
            N -= 26;
        }
        
        return ans.toString();
    }
    
    static String addLetters(int start, int end){
        StringBuilder ans = new StringBuilder();
        
        for(int i = start; i < end; i++){
            ans.append((char)('a' + i));
        }
        
        return ans.toString();
    }
}