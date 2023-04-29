//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> mat, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < mat.size(); i++){
            for(int j = 0; j < mat.get(0).size(); j++){
                if(mat.get(i).get(j) == 1){
                    adj.get(i).add(j);
                }
            }
        }
        
        
        int count = 0;
        
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                count++;
                dfs(adj, vis, i);
            }
        }
        
        return count;
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int vertex){
        vis[vertex] = true;
        
        for(int neigh: adj.get(vertex)){
            if(!vis[neigh]){
                dfs(adj, vis, neigh);
            }
        }
    }
};