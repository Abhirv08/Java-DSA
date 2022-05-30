class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while( i < nums.length){
            int correct_place = nums[i];
            int current_place = i;
            if(correct_place < nums.length && correct_place != current_place){
                int temp = nums[correct_place];
                nums[correct_place] = nums[current_place];
                nums[current_place] = temp;
            }else{
                i++;
            }
        }
        
        int ans = nums.length;
        for( i = 0; i < nums.length; i++){
            if(i != nums[i])
                ans = i;
        }
        return ans;
    }
}