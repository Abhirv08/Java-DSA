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
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long bestNode(int N, int[] A, int[] P) {
        Set<Integer> presentNodes = new HashSet<>();
        
        for(int i = 1; i < N; i++){
            presentNodes.add(P[i]);
        }
        
        List<Integer> leaf_nodes = new ArrayList<>();
        
        for(int i = 1; i < N+1; i++){
            if(!presentNodes.contains(i)){
                leaf_nodes.add(i);
            }
        }
        
        long ans = Integer.MIN_VALUE;
        for(int leaf: leaf_nodes){
            int curr_node = leaf;
            long sum = 0;
            
            while(curr_node != -1){
                sum = -1*sum;
                sum += A[curr_node - 1];
                ans = Math.max(ans, sum);
                
                curr_node = P[curr_node - 1];
            }
        }
        
        return ans;
    }
}
        
