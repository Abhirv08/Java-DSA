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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        HashSet<Integer> l_set = new HashSet<>();
        int[] l_a = new int[N];
        l_a[0] = 0;
        
        for(int i = 1; i < N; i++){
           if(!l_set.contains(A[i-1])){
               l_a[i] = l_a[i-1] + 1;
               l_set.add(A[i-1]);
           } else{
               l_a[i] = l_a[i-1];
           }
        }
        
        HashSet<Integer> r_set = new HashSet<>();
        int[] r_a = new int[N];
        r_a[N-1] = 0;
        
        for(int i = N-2; i >= 0; i--){
           if(!r_set.contains(A[i+1])){
               r_a[i] = r_a[i+1] + 1;
               r_set.add(A[i+1]);
           } else{
               r_a[i] = r_a[i+1];
           }
        }
        
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            list.add(l_a[i] - r_a[i]);
        }
         
        return list;
    }
}
        
