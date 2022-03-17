class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n <= 2) return 1;
        int[] nums = new int[n+1];
        for(int i = 0; i < n+1; i++) nums[i] = -1;
        nums[0] = 0; nums[1] = 1; nums[2] = 1;
        return helping(n, nums);
    }
    
    private int helping(int n, int[] nums){
        if(n==0) return 0;
        if(n <= 2) return 1;
        
        if(nums[n] >= 0){
            return nums[n];
        }
        
        int num = helping(n-1, nums) + helping(n-2, nums) + helping(n-3, nums);
        
        nums[n] = num;
        
        return num;
    }
}