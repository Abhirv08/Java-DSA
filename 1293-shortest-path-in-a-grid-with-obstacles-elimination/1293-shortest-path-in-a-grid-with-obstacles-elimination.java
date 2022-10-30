class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        for(int[] r: visited){
            Arrays.fill(r, -1);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, k});
        
        while(!q.isEmpty()){
            int[] currStat = q.remove();
            int row = currStat[0];
            int col = currStat[1];
            int dist = currStat[2];
            int remk = currStat[3];
            
            if(row < 0 || row == m || col < 0 || col == n) 
                continue;
            
            if(visited[row][col] != -1 && visited[row][col] >= remk){
                continue;
            }
            
            if(row == m-1 && col == n-1){
                return dist;
            }
            
            if(grid[row][col] == 1){
                if(remk > 0) 
                    remk--;
                else 
                    continue;
            }
            
            
            
            visited[row][col] = remk;
            
            q.add(new int[]{row-1, col, dist+1, remk});
            q.add(new int[]{row, col+1, dist+1, remk});
            q.add(new int[]{row+1, col, dist+1, remk});
            q.add(new int[]{row, col-1, dist+1, remk});
        }
        
        return -1;
    }
}