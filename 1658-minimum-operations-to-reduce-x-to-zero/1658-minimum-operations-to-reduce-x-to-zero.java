class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(x > sum) return -1;
        x = sum - x;
        return longestSubArray(nums, x);
    }
    
    private int longestSubArray(int[] nums, int x){
        int ans = 0;       
        int sum = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(memo.containsKey(sum - x)){
                ans = Math.max(ans, i - memo.get(sum-x));
            }
            memo.put(sum, i);
            
        }
        return ans == 0 ? (x == 0 ? nums.length : -1) : nums.length - ans;
    }    
}