class Solution {
    int ans = 0;
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1){
            return nums.length;
        }
        
        
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if(diff == 0){
                continue;
            }else if(diff > 0){
                ans += 2;
                wiggle(nums, i++, '+');
                break;
            }else{
                ans += 2;
                wiggle(nums, i++, '-');
                break;
            }
        }
        
        
        return ans == 0 ? 1 : ans;
    }
    
    private void wiggle(int[] nums, int currindex, char sign){
        if(currindex >= nums.length){
            return ;
        }
        
        int diff = nums[currindex] - nums[currindex - 1];
        
        if(diff == 0 || decideSign(diff) == sign){
            wiggle(nums, currindex+1, sign);
        }else{
            ans++;
            wiggle(nums, currindex+1, decideSign(diff));
        }
        
        return;
    }
    
    private char decideSign(int diff){
        if(diff < 0){
            return '-';
        }
        
        return '+';
    }
} 