class Solution {
    List<List<Integer>> adj;
    long fuel;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] road: roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        fuel = 0;
        dfs(0, -1, seats);
        return fuel;
    }
    
    private long dfs(int node, int parent, int seats){
        long reps = 1;
        
        for(int child: adj.get(node)){
            if(child != parent){
                reps += dfs(child, node, seats);
            }
        }
        
        if(node != 0){
            fuel += Math.ceil((double) reps/seats);
        }
        
        return reps;
    }
}