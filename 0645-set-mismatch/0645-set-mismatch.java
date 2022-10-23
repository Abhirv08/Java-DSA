class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        for(int i = 0; i < n;){
            int correctPlace = nums[i] - 1;
            if(nums[i] == nums[correctPlace]){
                i++;
            }else{
                int temp = nums[correctPlace];
                nums[correctPlace] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != nums[i] - 1){
                return new int[]{nums[i], i+1};
            }
        }
        
        return new int[0];
    }
}