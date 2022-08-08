class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        
        int[][] dp = new int[nums.length][nums.length + 1];
        
        
        for(int[] t : dp){
            Arrays.fill(t, -1);
        }
        
        // for(int i = 0; i < nums.length; i++){
        //     if(ans < nums.length - i){
        //         ans = Math.max(ans, 1 + lengthOfLIS(nums, i + 1, nums[i], dp));
        //     }
        // }
        
//         int lastNumTaken = 0;
//         for(int i = 0; i < nums.length; i++){
            
//             if(nums)
//         }
        
        return lengthOfLIS(nums, 0, -1, dp);
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