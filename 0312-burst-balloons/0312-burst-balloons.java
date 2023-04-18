class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n+2];
        nums2[0] = nums2[n+1] = 1;
        for(int i = 1; i < n+1; i++){
            nums2[i] = nums[i-1];
        }
        
        int[][] dp = new int[n+1][n+1];
        
        for(int[] a: dp) Arrays.fill(a, -1);
        
        return maxCoins(nums2, 1, n, dp);
    }
    
    private int maxCoins(int[] nums, int s, int e, int[][] dp){
        if(s > e) return 0;
        
        if(dp[s][e] != -1) return dp[s][e];
        
        int max = 0;
        for(int i = s; i <= e; i++){
            int sum = nums[s-1]*nums[i]*nums[e+1] + maxCoins(nums, s, i-1, dp)
                + maxCoins(nums, i+1, e, dp);
            if(max < sum) max = sum;
        }
        
        return dp[s][e] = max;
    }
}