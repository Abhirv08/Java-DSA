class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }        
        int ans = 0;
        int i = 2;
        int curr = 0;
        while(i < nums.length){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                curr++;
                ans += curr;
            }else{
                curr = 0;
            }
            i++;
        }
        
        return ans;
    }
}