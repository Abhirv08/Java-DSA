class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxMoney(nums, 0, dp);
    }
    
    private int maxMoney(int[] nums, int idx, int[] dp){
        if(idx >= nums.length) return 0;
        
        if(dp[idx] != -1) return dp[idx]; 
        // if not robbed
        int notRobbed = maxMoney(nums, idx + 1, dp);
        
        // if robbed
        int robbed = nums[idx] + maxMoney(nums, idx + 2, dp); 
        
        return dp[idx] = Math.max(notRobbed, robbed);
    }
}