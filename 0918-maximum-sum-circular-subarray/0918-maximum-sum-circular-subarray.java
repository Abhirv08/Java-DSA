class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], minSum = nums[0], sum = 0, currMin = 0, currMax = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            currMax = Math.max(currMax, 0) + nums[i];
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin, 0) + nums[i];
            minSum = Math.min(minSum, currMin);
        }
        
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}