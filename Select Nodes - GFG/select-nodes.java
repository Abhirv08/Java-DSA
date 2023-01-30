//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    int count = 0;
    public int countVertex(int N, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        countLights(N, adj, 1, new boolean[N+1]);
        
        return count;
    }
    
    boolean countLights(int n, List<List<Integer>> adj, int vertex, boolean[] vis){
        vis[vertex] = true;
        
        boolean selected = false;
        for(int neigh: adj.get(vertex)){
            if(!vis[neigh] && !countLights(n, adj, neigh, vis)){
                selected = true;
            }
        }
        
        if(selected) count++;
        return selected;
    }
    
}

//{ Driver Code Starts.

// } Driver Code Ends