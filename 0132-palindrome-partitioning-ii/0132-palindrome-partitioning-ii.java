class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        dp[n] = -1;
        for(int i = n-1; i >= 0; i--){
            int cuts = Integer.MAX_VALUE;
            for(int j = i+1; j <= n; j++){
                if(isPalindrome(s.substring(i, j))){
                    int cur = 1 + dp[j];            
                    cuts = Math.min(cuts, cur);
                }
            }

            dp[i] = (cuts == Integer.MAX_VALUE ? 0 : cuts);
        }
        
        // return minCuts(s, 0);
        return dp[0];
    }
    
    private boolean isPalindrome(String s){
        if(s.length() == 0) return false;
        
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}