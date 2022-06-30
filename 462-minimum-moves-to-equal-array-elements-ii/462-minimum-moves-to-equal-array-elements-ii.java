class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        if( (n & 1) == 1){
            int median = n/2;
            ans = findSteps(nums, median);            
        }else{            
            ans = Math.min( findSteps(nums, n/2), findSteps(nums, n/2-1) );
        }
        
        
        
        return ans;
    }
    
    private int findSteps(int[] nums, int median){
        int steps = 0;
        
        for(int i = 0; i < nums.length; i++){
            steps += Math.abs(nums[i] - nums[median]);
        }
        
        return steps;
    }
}