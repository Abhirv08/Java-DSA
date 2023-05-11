class Solution {
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        for(int idx1 = nums1.length - 1; idx1 >= 0; idx1--){
            for(int idx2 = nums2.length - 1; idx2 >= 0; idx2--){
                if(nums1[idx1] == nums2[idx2]){
                    dp[idx1][idx2] = 1 + dp[idx1 + 1][idx2 + 1];
                }else{
                    dp[idx1][idx2] = Math.max(dp[idx1 + 1][idx2], dp[idx1][idx2 + 1]);
                }                
            }
        }
        
        return dp[0][0];
    }
}