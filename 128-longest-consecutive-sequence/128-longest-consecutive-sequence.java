class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        
        int acq = 1; 
        int rel = 0;
        int ans = 1;
        for(; acq < nums.length; acq++){            
            
            if(nums[acq - 1] == nums[acq]){
                rel++;
                continue;
            }
            if(nums[acq] - nums[acq - 1] == 1){
                ans = Math.max(ans, acq - rel + 1);
            }else{
                rel = acq;
            }
        }
        
        return ans;
    }
}