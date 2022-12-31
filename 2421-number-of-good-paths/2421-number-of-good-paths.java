class Solution {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // essentially, starting from nodes with smaller values
        // UF will help identify connected components

        int n = vals.length, res = 0;
        List<Integer>[] adj = new ArrayList[n];
        TreeMap<Integer, List<Integer>> sameValues = new TreeMap<>();
        
        // init
        for (int  i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            List<Integer> l = sameValues.getOrDefault(vals[i], new ArrayList<>());
            l.add(i);
            sameValues.put(vals[i], l);
        }
        // build the graph
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            // only record u->v when vals[u] >= v;
            if (vals[a] >= vals[b]) adj[a].add(b);
            else adj[b].add(a);
        }
        
        UnionFind uf = new UnionFind(n);
        
        // scan the whole graph, starting from the smallest,
        // as this is a treemap
        for (int val : sameValues.keySet()) {
            // connect the nodes of this value with its neighbors
            // only big -> smaller
            for (int u : sameValues.get(val))
                for (int v : adj[u])
                    uf.union(u, v);
            
            // now we need to count the number of components
            // and when a component has more than 1 nodes of the val
            // know there are k * (k-1) / 2 more paths (1 unique path b/w each pair)
            // combination -> C^2_k
            
            Map<Integer, Integer> groups = new HashMap<>();
            for (int u : sameValues.get(val)) {
                int p = uf.find(u);
                groups.put(p, groups.getOrDefault(p, 0) + 1);
            }
            
            res += sameValues.get(val).size();
            
            for (int key : groups.keySet()) {
                int k = groups.get(key);
                res += k * (k-1) / 2; 
            }
                
        }
            
        
        return res;
    }
    
    class UnionFind {
        int parent[];
        int rank[];
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        
		// join by rank
        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (rank[a] > rank[b])
                    parent[b] = a;
                else if (rank[a] < rank[b])
                    parent[a] = b;
                else {
                    parent[b] = a;
                    rank[a]++;
                }
            }
        }
    
    }
}