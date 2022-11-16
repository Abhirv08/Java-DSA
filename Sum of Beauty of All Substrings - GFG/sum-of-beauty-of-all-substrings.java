//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int[] letters = new int[26];
            for(int j = i; j < s.length(); j++){
                letters[s.charAt(j) - 'a']++;
                ans += count(letters);
            }
        }

        return ans;
    }

    static int count(int[] letters){
        int max = 0, min = Integer.MAX_VALUE;

        for(int freq: letters){
            if(freq != 0){
                max = Math.max(freq, max);
                min = Math.min(freq, min);
            }
        }

        if(max == 0 || min == Integer.MAX_VALUE){
            return 0;
        }

        return max - min;
    }
    
}
        
