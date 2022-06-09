class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int i = 0;
        while (i <= numbers.length){
            int indexFound = bs(numbers, target - numbers[i], i+1);
            if (indexFound != -1){
                return( new int[] {i+1, indexFound+1});
            }else {
               i++;
            }
     }return new int[2] ;
    }
    
    private int bs(int[] nums, int target, int start){
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}