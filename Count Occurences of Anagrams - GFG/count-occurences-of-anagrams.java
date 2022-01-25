// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
          List<Integer> ans = new ArrayList<>();
        int k = pat.length();
        int[] pat_map = new int[26];
        for (int i = 0; i < k; i++) {
            char ch = pat.charAt(i);
            pat_map[ch-'a'] += 1;
        }
        int[] txt_map = new int[26];
        int l = 0;
        int r = 0;
        while(r < txt.length()){
            txt_map[txt.charAt(r) - 'a'] += 1;
            if (r-l+1 < k){
                r++;
            }else if (r-l+1 == k){
                if (isValid(pat_map, txt_map)){
                    ans.add(l);
                }
                txt_map[txt.charAt(l)-'a'] -= 1;
                l++;
                r++;
            }
        }
        return ans.size();
    }

    static boolean isValid(int[] pat_map, int[] txt_map){
        for (int i = 0; i < 26; i++) {
            if (pat_map[i]!=txt_map[i]){
                return false;
            }
        }
        return true;
    }
}