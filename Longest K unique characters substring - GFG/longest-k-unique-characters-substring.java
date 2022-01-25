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
        int[] letters = new int[26];
        int l = 0;
        int r = 0;
        int max = -1;
        boolean flag = true;
        while(r < s.length()){
            if (flag){
                letters[ s.charAt(r) - 'a' ] += 1;
            }
           if ( isValid(letters) < k ){
               r++;
               flag = true;
           }else if ( isValid(letters) == k) {
               max = Math.max(r-l+1, max);
               r++;
               flag = true;
           }else{
               letters[ s.charAt(l) - 'a' ] -= 1;
               l++;
               flag = false;
           }
        }
        return max;
    }

    static int isValid(int[] letters){
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0){
                count++;
            }
        }
        return count;
        
    }
}