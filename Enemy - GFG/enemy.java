//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            int n = a[0],m=a[1],k=a[2];
            
            int[][] e = IntMatrix.input(br, a[2], 2);
            
            Solution obj = new Solution();
            int res = obj.largestArea(n,m,k,e);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


       

class Solution {
    public static int largestArea(int n,int m,int k,int[][] enemy) {
        int[] rows = new int[k + 2];
        rows[0] = 0;
        int i = 1;
        for(int[] e: enemy){
            rows[i] = e[0];
            i++;
        }
        rows[i] = n+1;
        Arrays.sort(rows);
        
        int maxRowDiff = 0;
        for(i = 1; i < k + 2; i++){
            maxRowDiff = Math.max(maxRowDiff, rows[i] - rows[i - 1] - 1);
        }
        
        
        int[] cols = new int[k + 2];
        cols[0] = 0;
        i = 1;
        for(int[] e: enemy){
            cols[i] = e[1];
            i++;
        }
        cols[i] = m+1;
        Arrays.sort(cols);
        
        int maxColDiff = 0;
        for(i = 1; i < k + 2; i++){
            maxColDiff = Math.max(maxColDiff, cols[i] - cols[i - 1] - 1);
        }
        
        return maxRowDiff*maxColDiff;
    }
}
 
