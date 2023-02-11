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
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(P[i], i+1);
        }
        
        char[] chars = S.toCharArray();
        int ans = 0;
        
        for(int i = 0; i < N - 1; i++){
            if(chars[i] == chars[i+1]){
                int d1 = map.get(i);
                int d2 = map.get(i+1);
                if(d1 > d2){
                    ans = Math.max(ans, d2);
                    chars[i+1] = '?';
                }else{
                    ans = Math.max(ans, d1);
                    chars[i] = '?';
                }
            }
        }
        
        return ans;
    }
}
        
