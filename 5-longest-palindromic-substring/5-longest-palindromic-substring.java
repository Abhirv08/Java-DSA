class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
      if(n == 1) return s;
      if(n == 2){
         if (s.charAt(0) == s.charAt(1)) return s;
         else return s.substring(0,1);
      }
      boolean[][] dp = new boolean[n][n];
      int[] max = new int[2];
      int i = 0; int j = 0;
      boolean flag = true;
      while(flag){
         if(i == j) {
            dp[i][j] = true;
         }else{
            if(s.charAt(i) == s.charAt(j)){
               if(i + 1 == j || dp[i+1][j-1]){
                  dp[i][j] = true;
               }
            }
         }
         if(dp[i][j] && max[1] - max[0] <= j - i){
            max[0] = i;
            max[1] = j;
         }
         i++;
         j++;
         if(j == n){
            if(i == 1 && j == n) break;
            j = n + 1 - i;
            i = 0;

         }
      }


      return s.substring(max[0], max[1] + 1);
        
        
    }
}