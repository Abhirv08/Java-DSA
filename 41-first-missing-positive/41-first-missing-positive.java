class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == num){
                num++;
            }else if(nums[i] > num){
                break;
            }
        }
        return num;
    }
}