//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(A[i][j] >= 0){
                    populateList(A, i, j, list);
                }
            }
        }
        
        return list;
    }
    
    static void populateList(int[][] A, int row, int col, ArrayList<Integer> list){
        if(row < 0 || row == A.length || col < 0 || col == A.length){
            return ;
        }
        
        list.add(A[row][col]);
        A[row][col] = -1;
        populateList(A, row + 1, col - 1, list);
    }
    
}
