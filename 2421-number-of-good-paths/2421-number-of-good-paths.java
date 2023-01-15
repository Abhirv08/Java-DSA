class Solution {
    int[] parent;
    int[] rank;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        rank = new int[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            if(!map.containsKey(vals[i])) map.put(vals[i], new ArrayList<>());
            map.get(vals[i]).add(i);
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        } 
        
        int ans = n;
        
        for(int key: map.keySet()){
            for(int vrtx: map.get(key)){
                for(int neigh: adj.get(vrtx)){
                    if(vals[vrtx] >= vals[neigh]){
                        join(vrtx, neigh);
                    }
                }
            }
            
            HashMap<Integer, Integer> groups = new HashMap<>();
            for(int vrtx: map.get(key)){
                int p = findParent(vrtx);
                groups.put(p, groups.getOrDefault(p, 0) + 1);
            }
            
            for(int sz: groups.values()){
                ans += (sz*(sz-1))/2;
            }
        }
        
        return ans;
    }
    
    private int findParent(int vertex){
        if(parent[vertex] == vertex) return vertex;
        
        return parent[vertex] = findParent(parent[vertex]);
    }
    
    private void join(int v1, int v2){
        int p1 = findParent(v1);
        int p2 = findParent(v2);
        
        if(p1 == p2){
            return ;
        }else if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
            if(rank[p1] == rank[p2]) rank[p2]++;
        }
        
        return ;
    }
}