//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        int n = str.length();
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch < 'a'){
                upper[ch - 'A']++;
            }else{
                lower[ch - 'a']++;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        int upperp = 0, lowerp = 0;
        while(upper[upperp] == 0) upperp++;
        while(lower[lowerp] == 0) lowerp++;
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch < 'a'){
                ans.append((char)('A' + upperp));
                upper[upperp]--;
            }else{
                ans.append((char)('a' + lowerp));
                lower[lowerp]--;
            }
            
            while(upperp < 26 && upper[upperp] == 0) upperp++;
            while(lowerp < 26 && lower[lowerp] == 0) lowerp++;
        }
        
        return ans.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends