class Solution {
    public int rob(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) arr[i] = -1;
        return maxTheft(nums, 0, arr);
    }
    
    private int maxTheft(int[] nums, int currentHouse, int[] arr){
        if(currentHouse >= nums.length) return 0;
        
        int currentKey = currentHouse;
        
        if(arr[currentKey] >= 0){
            return arr[currentKey];
        }
        
        int loot1 = nums[currentKey] + maxTheft(nums, currentKey+2, arr);
        int loot2 = maxTheft(nums, currentKey+1, arr);
        
        int amountLooted = Math.max(loot1, loot2);
        
        arr[currentKey] = amountLooted;
        
        return amountLooted;
    }
    
}