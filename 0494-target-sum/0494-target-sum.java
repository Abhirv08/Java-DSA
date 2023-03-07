class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int maxSum = 0;
        for(int num: arr) maxSum += num;

        int[][] dp = new int[n][maxSum + 1];
        for(int[] r: dp) Arrays.fill(r, -1);

        return findWays(n, arr, target, n - 1, 0, dp);
    }
    
    private int findWays(int n, int[] arr, int target, int idx, int sum, int[][] dp){
        if(idx < 0){
            if(sum == target) return 1;
            return 0;
        }

        // if(dp[idx][target] != -1) return dp[idx][target];

        int ifAdded = findWays(n, arr, target, idx - 1, sum + arr[idx], dp);
        int ifSubtracted = findWays(n, arr, target, idx - 1, sum - arr[idx], dp);

        return ifAdded + ifSubtracted;
    }
}