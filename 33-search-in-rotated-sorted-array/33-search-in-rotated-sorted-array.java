class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
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
        if(target >= nums[0]){
            return BS(nums, target, 0, max_index);
        }else if( target <= nums[nums.length-1]  ){
            return BS(nums, target, max_index+1, nums.length-1);
        }
        return -1;
        
    }
    
    static int BS(int[] nums, int target, int start, int end){
         while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}