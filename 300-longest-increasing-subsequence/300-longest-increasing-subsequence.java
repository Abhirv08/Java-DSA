class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        
        
        // for(int[] t : dp){
        //     Arrays.fill(t, -1);
        // }
        
        int lastNumTaken = 0;
        for(int index = n-1; index >= 0; index--){            
            for(int prev_ind = index - 1; prev_ind >= -1; prev_ind--){
                int len = dp[index + 1][prev_ind + 1];
        
                if(prev_ind == -1 || nums[index] > nums[prev_ind]){
                    len =  Math.max(len, 1 + dp[index + 1][index + 1]);
                }   
        
                dp[index][prev_ind + 1] = len;
            }
        }
        
        return dp[0][-1+1];
    }
    
    private int lengthOfLIS(int[] nums, int index, int prev_ind, int[][] dp){
        if(index == nums.length){
            return 0;
        }
        
        
        if(dp[index][prev_ind + 1] != -1){
            return dp[index][prev_ind + 1];
        }
        
        int len = lengthOfLIS(nums, index + 1, prev_ind, dp);
        
        if(prev_ind == -1 || nums[index] > nums[prev_ind]){
            len =  Math.max(len, 1 + lengthOfLIS(nums, index + 1, index, dp));
        }   
        
        return dp[index][prev_ind + 1] = len;
    }
}