class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int idx = findShiftedIndex(i, j, n, k, total);
                sublist.add(grid[idx/n][idx%n]);
            }
            list.add(sublist);
        }
        
        return list;
    }
    
    public int findShiftedIndex(int i, int j, int col, int k, int total) {
        return (i * col + j - k + total) % total;
    }
}