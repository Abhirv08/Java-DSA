//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        int[] chars = new int[26];
        
        for(char ch: s.toCharArray()){
            chars[ch - 'a']++;
        }
        
        String balloon = "balloon";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(char ch: balloon.toCharArray()){
            map.put(ch - 'a', map.getOrDefault(ch - 'a', 0) + 1);
        }
        
        int ans = s.length();
        for(int idx: map.keySet()){
            int needed = map.get(idx);
            int actual = chars[idx];
            
            ans = Math.min(ans, actual/needed);
        }
        
        return ans;
    }
}