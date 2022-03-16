class Solution {
    public void rotate(int[] nums, int k) {
       //  k = k%(nums.length);
       //  int[] result = new int[nums.length];
       //  int index = 0;
       //  for(int i = nums.length - k; i < nums.length; i++ ){
       //      result[index] = nums[i];
       //      index++;
       //  }
       //  for(int i = 0; i <nums.length - k; i++ ){
       //      result[index] = nums[i];
       //      index++;
       //  }
       // for(int i = 0; i < nums.length; i++){
       //     nums[i] = result[i];
       // }
        k = k % nums.length;
        reverse(nums, 0, nums.length-1-k);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        
    }
    
    static void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}