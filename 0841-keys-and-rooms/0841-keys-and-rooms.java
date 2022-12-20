class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();        
        boolean[] vis = new boolean[n];
        canBeVisited(adj, 0, vis);
        
        for(boolean val: vis){
            if(!val) return false;
        }
        
        return true;
    }
    
    private void canBeVisited(List<List<Integer>> adj, int room, boolean[] vis){
        vis[room] = true;
        
        for(int key: adj.get(room)){
            if(!vis[key]){
                canBeVisited(adj, key, vis);
            }
        }
    }
}