class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int spSum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            spSum += (i*nums[i]);
        }
        
        int ans = spSum;
        for(int i = n-1; i >= 0; i--){
            spSum = spSum + sum - n*nums[i];
            ans = Math.max(ans, spSum);
        }
        
        return ans;
    }
}