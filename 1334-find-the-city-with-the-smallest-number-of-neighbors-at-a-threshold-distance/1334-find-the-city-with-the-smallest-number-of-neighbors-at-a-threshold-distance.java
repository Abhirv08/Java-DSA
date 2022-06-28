class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] costs = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    costs[i][j] = 0;
                }else{
                    costs[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            costs[a][b] = cost;
            costs[b][a] = cost;
        }
        
        for(int k = 0; k < n; k++){
            for(int source = 0; source < n; source++){
                for(int dest = 0; dest < n; dest++){
                    if(costs[source][k] != Integer.MAX_VALUE && costs[k][dest] != Integer.MAX_VALUE){
                        costs[source][dest] = Math.min(costs[source][dest], costs[source][k] + costs[k][dest]);
                    }
                }
            }
        }
        
        int min_cities = n;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int citiesReached = 0;
            for(int j = 0; j < n; j++){
                if(i != j && costs[i][j] <= distanceThreshold){
                    citiesReached++;
                }
            }
            if(citiesReached <= min_cities){
                min_cities = citiesReached;
                ans = i;
            }
        }
        
        return ans;
    }
}