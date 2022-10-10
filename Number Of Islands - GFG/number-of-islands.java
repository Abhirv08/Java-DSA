//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int[][] mat = new int[rows][cols];
        List<Integer> list = new ArrayList<>();
        
        for(int[] operator: operators){
            mat[operator[0]][operator[1]] = 1;
            
            boolean[][] visited = new boolean[rows][cols];
            int count = 0;
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(mat[i][j] == 1 && !visited[i][j]){
                        countIslands(mat, i, j, visited);
                        count++;
                    }
                }
            }
            list.add(count);
        }
        
        return list;
    }
    
    private void countIslands(int[][] mat, int rows, int cols, boolean[][] visited){
        if(rows < 0 || cols < 0 || rows == mat.length || cols == mat[0].length || visited[rows][cols] || mat[rows][cols] == 0){
            return ;
        }
        
        visited[rows][cols] = true;
        countIslands(mat, rows - 1, cols, visited);
        countIslands(mat, rows, cols + 1, visited);
        countIslands(mat, rows + 1, cols, visited);
        countIslands(mat, rows, cols - 1, visited);
        
        return ;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends