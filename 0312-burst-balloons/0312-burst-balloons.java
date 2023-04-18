class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n+2];
        nums2[0] = nums2[n+1] = 1;
        for(int i = 1; i < n+1; i++){
            nums2[i] = nums[i-1];
        }
        
        int[][] dp = new int[n+2][n+2];
        
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                int max = 0;
                for(int k = i; k <= j; k++){
                    int sum = nums2[i-1]*nums2[k]*nums2[j+1] + dp[i][k-1]
                        + dp[k+1][j];
                    if(max < sum) max = sum;
                }

                dp[i][j] = max;
            }
        }
        
        // return maxCoins(nums2, 1, n, dp);
        return dp[1][n];
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