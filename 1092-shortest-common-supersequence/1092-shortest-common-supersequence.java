class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int s1_l = s1.length();
        int s2_l = s2.length();
        
        int[][] dp = new int[s1_l + 1][s2_l + 1];
        
        for(int i = 1; i < s1_l + 1; i++){
            for(int j = 1; j < s2_l + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max( dp[i - 1][j], dp[i][j - 1] );
                }
            }
        }
        
        int i = s1_l;
        int j = s2_l;
        
        StringBuilder ans = new StringBuilder();
        
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1) ){
                ans.insert(0, s1.charAt(i - 1));
                i--; j--;
            }else{
                if(dp[i - 1][j] > dp[i][j - 1]){
                    ans.insert(0, s1.charAt(i - 1));
                    i--;
                }else{
                    ans.insert(0, s2.charAt(j - 1));
                    j--;
                }
            }
        }
        
        while(i > 0){
            ans.insert(0, s1.charAt(i - 1));
            i--;
        }
        
        while(j > 0){
            ans.insert(0, s2.charAt(j - 1));
            j--;
        }
        
        return ans.toString();
    }
}