class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return countSubSeq(s, 0, t, 0, dp);        
    }
    
    private int countSubSeq(String s, int i1, String t, int i2, int[][] dp){
        if(i2 == t.length()) return 1;
        
        if(i1 == s.length()){
            return 0;
        }
        
        if(dp[i1][i2] != -1) return dp[i1][i2];
        
        int take = 0;
        if(s.charAt(i1) == t.charAt(i2)){
            take = countSubSeq(s, i1+1, t, i2+1, dp);
        }
        
        int notTake = countSubSeq(s, i1+1, t, i2, dp);
        
        return dp[i1][i2] = take + notTake;
    }
}