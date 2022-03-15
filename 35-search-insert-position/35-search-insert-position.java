class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
            if(Arrays.asList(0,1).contains(end - start)) break;
        }
        return start + 1;
    }
}