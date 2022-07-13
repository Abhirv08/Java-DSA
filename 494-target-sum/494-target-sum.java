class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums, target, nums.length, 0);
    }
    
    static int targetSum(int[] nums, int target, int n, int currVal){
        if(n == 0){
            if(currVal == target){
                return 1;
            }else{
                return 0;
            }
        }
        
        int bytakingPositive = targetSum(nums, target, n-1, currVal + nums[n-1]);
        
        int byTakingnegative = targetSum(nums, target, n-1, currVal - nums[n-1]);
        
        return bytakingPositive + byTakingnegative;
    }
}