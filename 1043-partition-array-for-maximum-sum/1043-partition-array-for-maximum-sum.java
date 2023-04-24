class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[arr.length+1];
        dp[arr.length] = 0;
        for(int i = n-1; i >= 0; i--){
            int sum = 0, max = 0, ans = 0;
            for(int j = i; j < i + k && j < arr.length; j++){
                max = Math.max(max, arr[j]);
                sum = (j-i+1)*max + dp[j+1];

                ans = Math.max(ans, sum);
            }

            dp[i] = ans;
        }
        
        return dp[0];
    }
}