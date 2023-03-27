class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] r: dp) Arrays.fill(r, -1);
        
        return findLength(nums, 0, -1, dp);
    }
    
    private int findLength(int[] nums, int i, int prev_i, int[][] dp){
        if(i == nums.length) return 0;
        
        if(dp[i][prev_i+1] != -1) return dp[i][prev_i+1];
        
        if(prev_i >= 0 && nums[i] <= nums[prev_i]){
            return dp[i][prev_i+1] = findLength(nums, i+1, prev_i, dp);
        }
        
        int take = 1 + findLength(nums, i+1, i, dp);
        int dontTake = findLength(nums, i+1, prev_i, dp);
        return dp[i][prev_i+1] = Math.max(take, dontTake);
    }
}