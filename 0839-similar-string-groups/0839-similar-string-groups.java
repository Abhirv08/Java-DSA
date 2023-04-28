class Solution {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>> adj = new ArrayList<>();
        
        int n = strs.length;
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isSimilar(strs[i], strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(adj, vis, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(List<List<Integer>> adj, boolean[] vis, int vertex){
        vis[vertex] = true;
        
        for(int neigh: adj.get(vertex)){
            if(!vis[neigh]){
                dfs(adj, vis, neigh);
            }
        }
    }
    
    private boolean isSimilar(String s1, String s2){
        int n = s1.length();
        int diff = 0;
        
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)) diff++;
        }
        
        return diff == 0 || diff == 2;
    }
}