class Solution {
    int mod = (int) (1e9+7);
    int[][] hasApple;
    public int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        char[][] mat = new char[rows][cols];
        
        int i = 0;
        for(String p: pizza){
            mat[i] = p.toCharArray();
            i++;
        }
        
        hasApple = new int[rows+1][cols+1];
        countApple(mat);
        
        long[][][] dp = new long[rows][cols][k];
        for(long[][] m: dp){
            for(long[] r: m){
                Arrays.fill(r, -1);
            }
        }
        return (int) (countWays(mat, 0, 0, k-1, dp)%mod);
    }
    
    private long countWays(char[][] mat, int cr, int cc, int cuts, long[][][] dp){
        if(hasApple[cr][cc] == 0) return 0;
        
        if(cuts == 0) return 1;
        
        if(dp[cr][cc][cuts] > 0) return dp[cr][cc][cuts];
        
        long ans = 0;
        for(int nc = cc + 1; nc < mat[0].length; nc++){
            if(hasApple[cr][cc] - hasApple[cr][nc] > 0){
                ans += countWays(mat, cr, nc, cuts-1, dp)%mod;
            }
        }
        
        for(int nr = cr + 1; nr < mat.length; nr++){
            if(hasApple[cr][cc] - hasApple[nr][cc] > 0){
                ans += countWays(mat, nr, cc, cuts-1, dp)%mod;
            }
        }
        
        return dp[cr][cc][cuts] = ans%mod;
    }
    
    private void countApple(char[][] mat){        
        for(int i = mat.length-1; i >= 0; i--){
            for(int j = mat[0].length - 1; j >= 0; j--){
                hasApple[i][j] = hasApple[i+1][j] + hasApple[i][j+1] - hasApple[i+1][j+1] + (mat[i][j] == 'A' ? 1 : 0);
            }
        }
    }
}