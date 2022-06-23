// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];
        int visitedVertices = 0;
        
        for(int i = 0; i < V; i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour] += 1;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            if(visited[node]){
                continue;
            }
            
            visited[node] = true;
            visitedVertices += 1;
            
            for(int neighbour : adj.get(node)){
                indegree[neighbour] -= 1;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        
        
        return !(visitedVertices == V);
    }
}