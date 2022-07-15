class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int t1_size = t1.length();
        int t2_size = t2.length();
        
        int[][] memo = new int[t1_size + 1][t2_size + 1];
        
        for(int i = 1; i < t1_size + 1; i++){
            for(int j = 1; j < t2_size + 1; j++){
                if(t2.charAt(j - 1) == t1.charAt(i - 1)){
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else{
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j-1]);
                }
            }
        }
        
        return memo[t1_size][t2_size];       
        
        
    }
    
    private int lcs(String t1, String t2, int i1, int i2, int[][] memo){
        if(i1 == 0 || i2 == 0){
            return 0;
        }
        
        if(memo[i1][i2] != -1){
            return memo[i1][i2];
        }
        
        if(t1.charAt(i1 - 1) == t2.charAt(i2 - 1)){
            return 1 + lcs(t1, t2, i1 - 1, i2 - 1, memo);
        }
        
        int p1 = lcs(t1, t2, i1 - 1, i2, memo);
        int p2 = lcs(t1, t2, i1, i2 - 1, memo);
        
        memo[i1][i2] = Math.max(p1, p2);
        
        return Math.max(p1, p2);
    }
}