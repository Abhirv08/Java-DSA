class Solution {
    public int arraySign(int[] nums) {
        int n = nums.length;
        int prod = 1;
        
        for(int num: nums){
            if(num > 0) prod *= 1;
            else if(num < 0) prod *= -1;
            else prod = 0;
        }
        
        if(prod > 0){
            return 1;
        }else if(prod < 0) return -1;
        
        return 0;
    }
}