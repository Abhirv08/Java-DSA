class Solution {
    int[][] dp ;
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            max = Math.max(max, arr[i]);
        }
        
        // System.out.println(max);
        
        dp = new int[n][n];
        
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == max){
                count += countLIS(arr, nums, i, i);
            }
        }
        
        return count;
    }
    
    private int countLIS(int[] arr, int[] nums, int idx, int prevIdx){
        if(arr[prevIdx] == 1) return 1;
        if(idx == 0){
            return 0;
        }
        
        if(dp[idx][prevIdx] != -1) return dp[idx][prevIdx];
            
        int count = 0;
        for(int i = idx - 1; i >= 0; i--){
            if(arr[i] == arr[prevIdx] - 1 && nums[prevIdx] > nums[i]){
                count += countLIS(arr, nums, i, i);
            }
        }
        
        return dp[idx][prevIdx] = count;
    }
}