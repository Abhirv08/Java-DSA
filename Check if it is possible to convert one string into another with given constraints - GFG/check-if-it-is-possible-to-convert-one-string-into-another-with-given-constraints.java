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
            String S[] = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isItPossible(String S, String T, int M, int N) {
        if(M != N) return 0;
        
        int i = 0, j = 0;
        // i for S, j for T
        while(i < M && j < N){
            if(S.charAt(i) == T.charAt(j)){
                if(S.charAt(i) == 'A'){
                    if(i < j) return 0;
                }else if(S.charAt(i) == 'B'){
                    if(i > j) return 0;
                }
                i++;
                j++;
            }else if(S.charAt(i) == '#'){
                i++;
            }else{
                j++;
            }
        }
        
        while(i < M){
            if(S.charAt(i) != '#') return 0;
            i++;
        }
        
        while(j < N){
            if(T.charAt(j) != '#') return 0;
            j++;
        }
        
        return 1;
    }
    
};