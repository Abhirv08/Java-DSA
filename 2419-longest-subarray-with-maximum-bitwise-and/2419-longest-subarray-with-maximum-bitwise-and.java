class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int maxLength = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                maxLength = 1;
                while(i+1 < nums.length && nums[i+1] == nums[i]){
                    maxLength++;
                    i++;
                }
            }else if(nums[i] == max){
                int tempLength = 1;
                while(i+1 < nums.length && nums[i+1] == max){
                    i++;
                    tempLength++;                    
                }
                maxLength = Math.max(tempLength, maxLength);
            }
        }
        
        return maxLength;
        
    }
}