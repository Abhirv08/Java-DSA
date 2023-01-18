class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
               
        int suffixSum = nums[n-1];
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        for(int i = n - 2; i >= 0; i--){
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i+1], suffixSum);            
        }
        
        int prefixSum = 0, maxSum = nums[0], currMax = 0, specialSum = nums[0];
        for(int i = 0; i < n; i++){
            currMax = Math.max(currMax, 0) + nums[i];
            maxSum = Math.max(maxSum, currMax);
            prefixSum += nums[i];
            if(i+1 < n){
                specialSum = Math.max(specialSum, prefixSum + rightMax[i+1]);
            }
        }
        
        return Math.max(maxSum, specialSum);
    }
}