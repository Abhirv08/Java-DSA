//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        int ans = 1;
        
        for(char ch = 'A'; ch <= 'Z'; ch++){
            int ct = 0;
            int left = 0, right = 0;
            while(right < s.length()){
                if(s.charAt(right) == ch){
                    ans = Math.max(ans, right - left + 1);
                    right++;
                }else{
                    if(ct < k){
                        ct++;
                        ans = Math.max(ans, right - left + 1);
                        right++;
                    }else{
                        while(left < s.length() && s.charAt(left) == ch){
                            left++;
                        }
                        
                        left++;
                        ct--;
                    }
                }
            }
        }
        
        
        return ans;
    }
}