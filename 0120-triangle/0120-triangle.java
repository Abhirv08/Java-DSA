class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        dp = new int[m][m];
        for(int[] row: dp) Arrays.fill(row, -1);
        
        return minSum(triangle, 0, 0);
    }
    
    private int minSum(List<List<Integer>> triangle, int idx, int prev){
        if(idx == triangle.size() - 1){
            int min = Integer.MAX_VALUE;
            for(int i = prev; i <= prev+1 && i < triangle.get(idx).size(); i++){
                min = Math.min(min, triangle.get(idx).get(i));
            }
            return min;
        }
        
        if(dp[idx][prev] != -1) return dp[idx][prev];
        
        int min = Integer.MAX_VALUE;
        for(int i = prev; i <= prev+1 && i < triangle.get(idx).size(); i++){
            int sum = triangle.get(idx).get(i) + minSum(triangle, idx+1, i);
            min = Math.min(min, sum);
        }
        
        return dp[idx][prev] = min;        
    }
}