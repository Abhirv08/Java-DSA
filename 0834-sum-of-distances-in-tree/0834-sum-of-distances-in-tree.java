class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int[] ans = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        populateCount(adj, 0, -1, count, ans);
        populateAns(n, adj, 0, -1, count, ans);
        
        return ans;
    }
    
    private void populateAns(int n, List<List<Integer>> adj, int node, int parent, int[] count, int[] ans){
        for(int child: adj.get(node)){
            if(child != parent){
                ans[child] = ans[node] - count[child] + (n - count[child]);
                populateAns(n, adj, child, node, count, ans);
            }
        }
    }
    
    private void populateCount(List<List<Integer>> adj, int node, int parent, int[] count, int[] ans){
        for(int child: adj.get(node)){
            if(child != parent){
                populateCount(adj, child, node, count, ans);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }
}