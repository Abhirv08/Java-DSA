// { Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int ans = 0;
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        ArrayList<ArrayList<Integer>> adj = constructGraph(edges, n);
        isPossible(adj, s, d, new boolean[n]);
        
        return ans;
    }
    
    private void isPossible(ArrayList<ArrayList<Integer>> adj, int currentVertex, int target, boolean[] visited){
        if(currentVertex == target){
            ans++;
            return;
        }
        
        visited[currentVertex] = true;
        
        for(int currNeigh : adj.get(currentVertex)){
            if(!visited[currNeigh])
                isPossible(adj, currNeigh, target, visited);
            
        }
        
        visited[currentVertex] = false;
        return ;
    }
    
    private ArrayList<ArrayList<Integer>> constructGraph(int[][] edges, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        return adj;
    }
    
}