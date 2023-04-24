class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSum(arr, k, 0);
    }
    
    private int maxSum(int[] arr, int k, int idx){
        if(idx == arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int sum = 0, max = 0, ans = 0;
        for(int i = idx; i < idx + k && i < arr.length; i++){
            max = Math.max(max, arr[i]);
            sum = (i-idx+1)*max + maxSum(arr, k, i+1);
            
            ans = Math.max(ans, sum);
        }
        
        return dp[idx] = ans;
    }
}