// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if(m[n-1][n-1] == 0){
            ans.add("-1");
            return ans;
        }
        findPath(m, 0, 0, "", ans);
        return ans;
    }
    
    static void findPath(int[][] m, int r, int c, String s, ArrayList<String> ans){
        if(r == m.length-1 && c == m.length-1){
            ans.add(s);
            return;
        }
        if(r < 0 || r == m.length){
            return;
        }
        if(c < 0 || c == m.length){
            return;
        }
        if( m[r][c] <= 0){
            return;
        }
        m[r][c] = -1;
        findPath(m, r-1, c, s + "U", ans);
        findPath(m, r, c+1, s + "R", ans);
        findPath(m, r+1, c, s + "D", ans);
        findPath(m, r, c-1, s + "L", ans);
        m[r][c] = 1;
        
        return;
    }
    
    
}