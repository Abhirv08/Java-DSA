class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return match(m, s, m-1, n, p, n-1, dp);
        
    }
    
    private boolean match(int m, String s, int i1, int n, String p, int i2, int[][] dp){
        if(i2 < 0){
            if(i1 >= 0) return false;
            return true;
        }
        
        if(i1 < 0){
            while(i2 >= 0 && p.charAt(i2) == '*') i2--;
            if(i2 < 0) return true;
            return false;
        }
        
        if(dp[i1+1][i2+1] != -1) return dp[i1+1][i2+1] > 0;
        
        if(p.charAt(i2) == s.charAt(i1) || p.charAt(i2) == '?'){
            boolean res = match(m, s, i1-1, n, p, i2-1, dp);
            dp[i1+1][i2+1] = res ? 1 : 0;
            return res;
        }else if(p.charAt(i2) == '*'){
            boolean ans = false;
            for(int i = 0; i <= m; i++){
                ans = ans | match(m, s, i1-i, n, p, i2-1, dp);
            }
            
            dp[i1+1][i2+1] = (ans ? 1 : 0);
                
            return ans;
        }
        
        dp[i1+1][i2+1] = 0;
        return false;
    }
}