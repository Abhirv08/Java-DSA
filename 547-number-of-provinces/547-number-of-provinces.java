class Solution {
    // city = currentCity + 1;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        for(int currentCity = 0; currentCity < n; currentCity++){
            if(!visited[currentCity] ){
                dfs(isConnected, visited, currentCity);
                ans++;
            }
        }
        return ans;
    }
    
    private void dfs(int[][] iC, boolean[] visited, int currentCity){        
        visited[currentCity] = true;
        
        int[] neighbours = iC[currentCity];
        for(int neighbour = 0; neighbour < neighbours.length; neighbour++){
            if(!visited[neighbour] && iC[currentCity][neighbour] == 1){
                dfs(iC, visited, neighbour);
            }
        }
    }
}