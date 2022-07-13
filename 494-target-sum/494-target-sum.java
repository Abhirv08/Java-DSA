class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums, target, nums.length, 0, new HashMap<>());
    }
    
    static int targetSum(int[] nums, int target, int n, int currVal, HashMap<String, Integer> memo){
        if(n == 0){
            if(currVal == target){
                return 1;
            }else{
                return 0;
            }
        }
        
        String s = currVal + ":" + n;
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        int bytakingPositive = targetSum(nums, target, n-1, currVal + nums[n-1], memo);
        
        int byTakingnegative = targetSum(nums, target, n-1, currVal - nums[n-1], memo);
        
        memo.put(s, bytakingPositive + byTakingnegative);
        
        return bytakingPositive + byTakingnegative;
    }
}