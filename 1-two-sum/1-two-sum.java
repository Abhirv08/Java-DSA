class Solution {
    public int[] twoSum(int[] nums, int k) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!memo.containsKey(k - nums[i])){
                memo.put(nums[i], i);
            }else{
                ans[0] = memo.get(k - nums[i]);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}