class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        
        int[][] dp = new int[piles.size()][k+1];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return getMaxValue(piles, 0, k, dp);
    }
    
    private int getMaxValue(List<List<Integer>> piles, int idx, int k, int[][] dp){
        if(k < 0) return Integer.MIN_VALUE;
        if(k == 0 || idx == piles.size()) return 0;
        
        if(dp[idx][k] != -1) return dp[idx][k];
        
        int val = getMaxValue(piles, idx+1, k, dp);
        
        List<Integer> pile = piles.get(idx);
        int curr = 0;
        for(int i = 0; i < pile.size(); i++){
           curr += pile.get(i);
            val = Math.max(val, curr + getMaxValue(piles, idx+1, k-i-1, dp));
        }
        
        return dp[idx][k] = val;
    }
}