class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] cuts2 = new int[m+2];
        Arrays.sort(cuts);
        for(int i = 1; i < m + 1; i++){
            cuts2[i] = cuts[i-1];
        }
        cuts2[m+1] = n;
        dp = new int[m+2][m+2];
        for(int[] a: dp) Arrays.fill(a, -1);
        return findMinCost(cuts2, 1, m);
    }
    
    private int findMinCost(int[] cuts, int i, int j){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int minCost = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cost = (cuts[j + 1] - cuts[i - 1]) + findMinCost(cuts, i, idx - 1)
                    + findMinCost(cuts, idx + 1, j);
            if(minCost > cost) minCost = cost;
        }
        
        return dp[i][j] = (minCost == Integer.MAX_VALUE ? 0 : minCost);
    }
} 