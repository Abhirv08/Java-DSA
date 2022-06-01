class Solution {
    public int[] runningSum(int[] nums) {
        int presum = 0;
        for(int i = 0; i < nums.length; i++){
            presum += nums[i];
            nums[i] = presum;
        }
        return nums;
    }
}