//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        int[] letters = new int[26];
        
        int vowel = 0;
        for(char ch: S.toCharArray()){
            letters[ch - 'a']++;
            if(isVowel(ch)) vowel++;
        }
        
        int conso = N - vowel;
        if(Math.abs(N - 2*vowel) > 1) return "-1";
        
        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder vowels = new StringBuilder();
        
        for(char ch: chars){
            int freq = letters[ch - 'a'];
            while(freq-- > 0){
                vowels.append(ch);
            }
            letters[ch - 'a'] = 0;
        }
        
        StringBuilder consonants = new StringBuilder();
        for(int i = 0; i < 26; i++){
            int freq = letters[i];
            while(freq-- > 0){
                consonants.append((char)('a' + i));
            }
        }
        
        int vidx = 0, cidx = 0;
        StringBuilder ans = new StringBuilder();
        
        while(vidx < vowels.length() && cidx < consonants.length()){
            if(vowel > conso || (vowel == conso && vowels.charAt(0) < consonants.charAt(0))){
                ans.append(vowels.charAt(vidx)).append(consonants.charAt(cidx));
            }else if(vowel < conso || (vowel == conso && vowels.charAt(0) > consonants.charAt(0))){
                ans.append(consonants.charAt(cidx)).append(vowels.charAt(vidx));
            }
            vidx++;
            cidx++;
        }

        while(vidx < vowels.length()){
            ans.append(vowels.charAt(vidx));
            vidx++;
        }

        while(cidx < consonants.length()){
            ans.append(consonants.charAt(cidx));
            cidx++;
        }
        
        return ans.toString();
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        
        return false;
    }
}