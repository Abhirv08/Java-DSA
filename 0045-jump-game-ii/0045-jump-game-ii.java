class Solution {
    static public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 100001);
        for(int i = n-2; i >= 0; i--){
            for(int j = i + 1; j < n && j <= i + nums[i]; j++){
                if(j == n-1){
                    dp[i] = 1;
                    continue;
                }
                int moreSteps = 1 + dp[j];
                dp[i] = Math.min(dp[i], moreSteps);
            }
        }

        return dp[0];
    }
}