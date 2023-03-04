class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        
        int leftBound = -1, minPos = -1, maxPos = -1;
        
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == minK){
                minPos = i;
            }
            if(nums[i] == maxK){
                maxPos = i;
            }
            
            if(nums[i] < minK || nums[i] > maxK){
                leftBound = i;
            }
            
            long val = Math.min(minPos, maxPos) - leftBound;
            if(val > 0){
                ans += val;
            }
        }
        
        return ans;
    }
}