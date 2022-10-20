//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.getSum(x, y, z));
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

class Solution {
    public int getSum(int X, int Y, int Z) {
        int mod = 1000000007;
        long ans = 0;
        long[][][] maxSum = new long[X+1][Y+1][Z+1];
        long[][][] num = new long[X+1][Y+1][Z+1];
        num[0][0][0] = 1L;
        
        for(int i = 0; i < X+1; i++){
            for(int j = 0; j < Y+1; j++){
                for(int k = 0; k < Z+1; k++){
                    if(i > 0){
                        maxSum[i][j][k] += (maxSum[i - 1][j][k]*10 + 4*num[i - 1][j][k])%mod;
                        num[i][j][k] += num[i - 1][j][k]%mod;
                    }
                    if(j > 0){
                        maxSum[i][j][k] += (maxSum[i][j - 1][k]*10 + 5*num[i][j - 1][k])%mod;
                        num[i][j][k] += num[i][j - 1][k]%mod;
                    }
                    if(k > 0){
                        maxSum[i][j][k] += (maxSum[i][j][k - 1]*10 + 6*num[i][j][k - 1])%mod;
                        num[i][j][k] += num[i][j][k - 1]%mod;
                    }
                    
                    ans = (ans%mod +  maxSum[i][j][k]%mod)%mod;
                }
            }
        }
        
        return (int)ans;
    }
}