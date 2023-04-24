class Solution {
    int[] dp;
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return minCuts(s, 0);
    }
    
    private int minCuts(String s, int idx){
        if(idx == s.length()) return -1;
        
        if(dp[idx] != -1) return dp[idx];
        
        int cuts = Integer.MAX_VALUE;
        for(int i = idx+1; i <= s.length(); i++){
            if(isPalindrome(s.substring(idx, i))){
                int cur = 1 + minCuts(s, i);            
                cuts = Math.min(cuts, cur);
            }
        }
        
        return dp[idx] = (cuts == Integer.MAX_VALUE ? 0 : cuts);
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