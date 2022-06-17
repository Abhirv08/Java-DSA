// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }
        int distinctCharacters = set.size();
        int distn = 0;
        int acq = 0;
        int rel = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        while(acq < str.length()){
            if(!memo.containsKey(str.charAt(acq))){
                memo.put(str.charAt(acq), 1);
                distn++;
            }else{
                memo.put(str.charAt(acq), memo.get(str.charAt(acq)) + 1);
            }
            
            while(distn == distinctCharacters){
                ans = Math.min(ans, acq - rel + 1);
                memo.put(str.charAt(rel), memo.get(str.charAt(rel)) - 1);
                if(memo.get(str.charAt(rel)) == 0){
                    memo.remove(str.charAt(rel));
                    distn--;
                }
                
                rel++;
            }
            
            acq++;
            
        }
        return ans;
    }
}