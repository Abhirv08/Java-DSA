class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for(List<Integer> l: piles){
            for(int i = 1; i < l.size(); i++){
                int num = l.get(i);
                l.remove(i);
                l.add(i, num + l.get(i-1));
            }
        }
        
        int[][] dp = new int[piles.size()][k+1];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        int maxVal = getMaxValue(piles, 0, k, dp);
        
        return maxVal;
    }
    
    private int getMaxValue(List<List<Integer>> piles, int idx, int k, int[][] dp){
        if(k < 0) return Integer.MIN_VALUE; 
        if(k == 0 || idx == piles.size()) return 0;
        
        if(dp[idx][k] != -1) return dp[idx][k];
        
        int val = 0;
        List<Integer> pile = piles.get(idx);
        for(int i = 0; i < pile.size(); i++){
            int lastCoins = pile.get(i);
            val = Math.max(val, lastCoins + getMaxValue(piles, idx+1, k-i-1, dp));
        }
        
        val = Math.max(val, getMaxValue(piles, idx+1, k, dp));
        
        return dp[idx][k] = val;
    }
}