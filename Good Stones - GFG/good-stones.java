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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static int[] vis;
    public static int goodStones(int n, int[] arr) {
        vis = new int[n];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < n; i++){
            if(vis[i] == -1) dfs(n, arr, i);
        }
        
        //System.out.println(Arrays.toString(vis));
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 1) ans++;
        }
        
        return ans;
    }
    
    static int dfs(int n, int[] arr, int idx){
        if(idx >= n || idx < 0) return 1;
        if(vis[idx] != -1) return vis[idx];
        
        vis[idx] = 0;
        
        vis[idx] = dfs(n, arr, idx + arr[idx]);
        
        return vis[idx];
    }
}
        
