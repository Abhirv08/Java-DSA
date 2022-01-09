class Solution {
    public void rotate(int[] nums, int k) {
        k = k%(nums.length);
        // if(k > nums.length){
        //     return;
        // }
        int[] result = new int[nums.length];
        int index = 0;
        for(int i = nums.length - k; i < nums.length; i++ ){
            result[index] = nums[i];
            index++;
        }
        for(int i = 0; i <nums.length - k; i++ ){
            result[index] = nums[i];
            index++;
        }
       for(int i = 0; i < nums.length; i++){
           nums[i] = result[i];
       }
    }
}