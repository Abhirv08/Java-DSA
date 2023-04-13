class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        
        int acq = 0, rel = 0;
        int lessThankLeftCons = -1;
        while(acq < nums.length){
            if(nums[acq] >= left && nums[acq] <= right){
                count += (acq-rel+1);
                lessThankLeftCons = -1;
            }else if(nums[acq] < left){
                lessThankLeftCons++;
                count += (acq-rel) - lessThankLeftCons;
            }else if(nums[acq] > right){
                rel = acq + 1;
                lessThankLeftCons = -1;
            }
            acq++;
        }
        
        return count;
    }
}