class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int acq = 0;
        int rel = 0;
        int maxcons = 0;
        for(; acq < nums.length; acq++){
            if(nums[acq] == 0){
                rel = acq+1;
            }
            maxcons = Math.max(maxcons, acq-rel+1);
        }
        return maxcons;
    }
}