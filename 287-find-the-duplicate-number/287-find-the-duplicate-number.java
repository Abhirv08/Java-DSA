class Solution {
    public int findDuplicate(int[] nums) {        
        sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return nums[i];
            }
        }
        return -1;
    }
    
     static void sort(int[] nums){
        for(int i = 0; i< nums.length; ){
            int correctIndex = nums[i]-1;
            if (nums[i] == nums[correctIndex]) i++;
            else{
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
    }
}