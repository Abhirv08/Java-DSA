//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        int n = S.length();
        int[] chars = new int[26];
        for(char ch: S.toCharArray()){
            chars[ch - 'a']++;
        }
        
        StringBuilder str = new StringBuilder(S);
        int i = 0, j = n - 1;
        
        while(i < j){
            while(i < str.length() && chars[str.charAt(i) - 'a'] <= 1){
                i++;
            }
            
            if(i == str.length()) break;
            
            chars[str.charAt(i) - 'a']--;
            str.deleteCharAt(i);
            j--;
            
            while(j >= 0 && chars[str.charAt(j) - 'a'] <= 1){
                j--;
            }
            
            if(j < 0){
                str.reverse();
                break;
            }
            
            chars[str.charAt(j) - 'a']--;
            str.deleteCharAt(j);
            j--;
        }
        
        return str.toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends