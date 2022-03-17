class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n <= 2) return 1;
        int[] nums = new int[n+1];
        nums[0] = 0; nums[1] = 1; nums[2] = 1;
        return helping(n, nums);
    }
    
    private int helping(int n, int[] nums){
        
        for(int i = 3; i <= n; i++){
            nums[i] = nums[i-1] + nums[i-2] + nums[i-3]; 
        }
        
        return nums[nums.length-1];
        
        
        
    }
}