class Solution {
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }
        
        return maxLines(nums1, nums2, 0, 0);
    }
    
    private int maxLines(int[] nums1, int[] nums2, int idx1, int idx2){
        if(idx1 == nums1.length || idx2 == nums2.length) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(nums1[idx1] == nums2[idx2]){
            return dp[idx1][idx2] = 1 + maxLines(nums1, nums2, idx1 + 1, idx2 + 1);
        }
        
        int max = 0;
        int notTake = Math.max(maxLines(nums1, nums2, idx1 + 1, idx2), maxLines(nums1, nums2, idx1, idx2 + 1));
        
        max = Math.max(notTake, max);
        
        return dp[idx1][idx2] = max;
    }
}