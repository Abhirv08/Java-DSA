class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(k > 0){
                k--;
            }
            if(k == 0){
                return nums[i];
            }
        }
        return -1;
    }
}