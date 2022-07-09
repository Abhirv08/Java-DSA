// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends

class Edge implements Comparable<Edge>{
    int src, dest, weight;
    
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int compareTo(Edge e){
        return this.weight - e.weight;
    }
    
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        List<Edge> edges = getEdges(V, adj);
        
        Collections.sort(edges);
        
        int[] parent = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }
        
        int[] rank = new int[V];
        
        int ans = 0;
        int edgesTaken = 0;
        int i = 0;
        while(edgesTaken < V-1 && i < edges.size()){
            Edge edge = edges.get(i);
            int a = edge.src;
            int b = edge.dest;
            int weight = edge.weight;
            
            int rootA = find(parent, a);
            int rootB  = find(parent, b);
            
            if(rootA != rootB){
                union(parent, a, b, rank);
                ans += weight;
                edgesTaken++;
            }
            i++;
        }
        
        return ans;
    }
    
    static int find(int[] parent, int vertex){
        if(parent[vertex] == vertex){
            return vertex;
        }
    
        parent[vertex] = find(parent, parent[vertex]);
    
        return parent[vertex];
    }

    static void union(int[] parent, int a, int b, int[] rank){
        int rootA = find(parent, a);
        int rootB = find(parent, b);
    
        if(rank[rootA] < rank[rootB])
            parent[rootA] = rootB;
        else if(rank[rootA] > rank[rootB])
            parent[rootB] = rootA;
        else{
            parent[rootA] = rootB;
            rank[rootB]++;
        }
        return;
    }
    
    static List<Edge> getEdges(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Edge> edges = new ArrayList<>();
        
        
        for(int i = 0; i<v; i++){
            ArrayList<ArrayList<Integer>> neighbours = adj.get(i);
            for(ArrayList<Integer> currNeigh : neighbours){
                int src = i;
                int dest = currNeigh.get(0);
                int weight = currNeigh.get(1);
                
                edges.add(new Edge(src, dest, weight));
            }
        }
        
        return edges;
    }
}
