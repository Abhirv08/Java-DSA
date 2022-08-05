class Solution {
    public int combinationSum4(int[] nums, int target) {
        return combinations(nums, target, new HashMap<>());

    }
    
    private int combinations(int[] nums, int target, HashMap<Integer, Integer> memo){
        if(target < 0){
            return 0;
        }
        
        if(target == 0){
            return 1;
        }
        
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        
        int ways = 0;
        for(int i = 0; i < nums.length; i++){
            ways += combinations(nums, target - nums[i], memo);
        }
        
        memo.put(target, ways);

        return ways;
    }
}