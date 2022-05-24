// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int rel = 0;
        int longest = -1;
        int distn = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        for(int acq = 0 ; acq < s.length(); acq++){
            if(memo.containsKey(s.charAt(acq))){
                memo.put(s.charAt(acq), memo.get(s.charAt(acq)) + 1);
            }else{
                memo.put(s.charAt(acq), 1);
                distn++;
            }
            
            while(distn > k){
                if(memo.get(s.charAt(rel)) == 1){
                    memo.remove(s.charAt(rel));
                    distn--;
                }else{
                    memo.put(s.charAt(rel), memo.get(s.charAt(rel)) - 1);
                }
                rel++;
            }
            if(distn == k){
                longest = Math.max(longest, acq - rel + 1);
            }
        }
        return longest; 
    }

}