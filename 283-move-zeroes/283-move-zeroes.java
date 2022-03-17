class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1) return;
        int i = 0;
        while(i < nums.length){
            if(nums[i] != 0){
                for(int j = i; j > 0; j--){
                    if(nums[j-1] == 0){
                        int temp = nums[j];
                        nums[j] = nums[j-1];
                        nums[j-1] = temp;
                    }
                }
            }
            i++;
        }
    }
}