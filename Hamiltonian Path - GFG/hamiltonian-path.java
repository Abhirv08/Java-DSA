//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        
        ArrayList<ArrayList<Integer>> adj = createGraph(Edges, N);
        
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < N+1; i++){
            if(dfs(adj, i, set, N)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int currNode, Set<Integer> set, int N){
        set.add(currNode);
        
        if(set.size() == N) return true;
        
        
        for(Integer neigh: adj.get(currNode)){
            if(!set.contains(neigh) && dfs(adj, neigh, set, N)){
                return true;
            }
        }
        
        set.remove(currNode);
        
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> createGraph(ArrayList<ArrayList<Integer>> Edges, int N){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge: Edges){
            int node1 = edge.get(0);
            int node2 = edge.get(1);
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        
        return adj;
    }
    
} 