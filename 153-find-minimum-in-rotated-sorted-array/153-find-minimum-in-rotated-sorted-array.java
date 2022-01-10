class Solution {
    public int findMin(int[] nums) {
         if(nums.length == 0){
            return -1;
        }
        if(nums[0] < nums[nums.length-1] || nums.length==1){
            return nums[0];
        }
        
        int max_index= 0;
        for(int i=1; i<nums.length; i++){
             if(nums[i] > nums[i-1]){
                max_index = i;
            }
            if(nums[i-1] > nums[i]){
                break;
            }
        }
        return nums[max_index+1];
    }
}