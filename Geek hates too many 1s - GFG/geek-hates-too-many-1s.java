//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        if(Integer.bitCount(n) < 3) return n;
        
        int[] bits = new int[32];
        int i = 0;
        while(n > 0){
            bits[i] = (n&1);
            n >>= 1;
            i++;
        }
        
        int num = 0;
        for(i = 31; i >= 0; i--){
            if(i - 1 > 0 && bits[i] == 1 && bits[i-1] == 1){
                bits[i-2] = 0;
            }
            
            num += bits[i]*(1 << i);
        }
        
        return num;
    }
}
        
