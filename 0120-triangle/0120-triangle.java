class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] row: dp) Arrays.fill(row, 1000000);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < i+1; j++){
                if(i == 0 && j == 0) dp[i][j] = triangle.get(0).get(0);
                else if(i > 0){
                    int up = 1000000, left = 1000000;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i-1][j-1];
                    
                    dp[i][j] = triangle.get(i).get(j) + Math.min(up, left);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            ans = Math.min(ans, dp[m-1][i]);
        }
        
        return ans;
    }
}