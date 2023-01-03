class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        if(nums[0] > nums[1]){
            min = max = nums[0];
        }
        
        for(int i = 1; i < n - 1; i++){
            if(nums[i-1] > nums[i] || (nums[i-1] < nums[i] && nums[i] > nums[i+1]) || nums[i] > nums[i+1]){
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
        }
        
        if(nums[n-1] < nums[n-2]){
            min = Math.min(min, nums[n-1]);
            max = Math.max(max, nums[n-1]);
        }
        
        //System.out.println(min);
        //System.out.println(max);
        
        int i = 0;
        while(i < nums.length && nums[i] <= min){
            i++;
        }
        
        if(i == nums.length){
            return 0;
        }
        
        int j = n - 1;
        while(j >= 0 && nums[j] >= max){
            j--;
        }
        
        return j - i + 1;
    }
}