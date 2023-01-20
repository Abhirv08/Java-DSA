class Solution {
    int[][] paths = {{0,1}, {1,0}};
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, grid[0][0]});
        int[][] minCost = new int[m][n];
        for(int[] row: minCost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            int[] currPos = pq.poll();
            int r = currPos[0];
            int c = currPos[1];
            int sum = currPos[2];

            if(r == m-1 && c == n-1){
                return sum;
            }
            
            for(int[] path: paths){
                int nr = r + path[0];
                int nc = c + path[1];
                if(nr < m && nc < n){
                    int ncost = sum + grid[nr][nc];
                    if(ncost < minCost[nr][nc]){
                        pq.add(new int[]{nr, nc, ncost});
                        minCost[nr][nc] = ncost;
                    }
                }
            }
        }

        return -1;
    }
}