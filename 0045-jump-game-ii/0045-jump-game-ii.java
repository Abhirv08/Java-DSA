class Solution {
    static public int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return findSteps(n, nums, 0, dp);
    }

    static int findSteps(int n, int[] nums, int idx, int[] dp){
        if(idx == n-1){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];
        int ans = 100001;
        for(int i = idx + 1; i < n && i <= idx + nums[idx]; i++){
                int moreSteps = 1 + findSteps(n, nums, i, dp);
                ans = Math.min(ans, moreSteps);
        }

        return dp[idx] = ans;
    }
}