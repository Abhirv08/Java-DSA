class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        
        int l = 0, r = n - 1;
        
        while(l < r){
            int m = l + (r - l)/2;
            
            if(nums[m] == target) return m;
            else if(nums[m] > target) r = m;
            else l = m + 1;
        }
        
        if(r == n - 1 && nums[r] < target) return n;
        return r;
    }
}