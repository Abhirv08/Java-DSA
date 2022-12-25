//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        int n = matrix.length;
        int[] zero = new int[2];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    zero[0] = i;
                    zero[1] = j;
                }
            }
        }
        
        long reqSum = 0;
        int row = zero[0] == 0 ? 1 : 0;
        
        for(int j = 0; j < n; j++){
            reqSum += matrix[row][j];
        }
        
        long zeroRowSum = 0;
        row = zero[0];
        for(int j = 0; j < n; j++){
            zeroRowSum += matrix[row][j];
        }
        
        long inPlaceOfZero = reqSum - zeroRowSum;
        if(inPlaceOfZero <= 0) return -1;
        
        // for every Row
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    sum += inPlaceOfZero;
                }else{
                    sum += matrix[i][j];
                }
            }
            if(sum != reqSum) return -1;
        }
        
        // for every Col
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = 0; j < n; j++){
                if(matrix[j][i] == 0){
                    sum += inPlaceOfZero;
                }else{
                    sum += matrix[j][i];
                }
            }
            if(sum != reqSum) return -1;
        }
        
        // for 1st Diagonal
        long dia1 = 0;
        for(int i = 0; i < n; i++){
            if(matrix[i][i] == 0){
                dia1 += inPlaceOfZero;
            }else{
                dia1 += matrix[i][i];
            }
        }
        
        if(dia1 != reqSum) return -1;
        
        // For 2nd Diagonal
        long dia2 = 0;
        for(int i = n - 1, j = 0; i >= 0 && j < n; i--, j++){
            if(matrix[i][j] == 0){
                dia2 += inPlaceOfZero;
            }else{
                dia2 += matrix[i][j];
            }
        }
        
        if(dia2 != reqSum) return -1;
        
        return inPlaceOfZero;
    }
}