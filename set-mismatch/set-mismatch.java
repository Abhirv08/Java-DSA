class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int repeated_num =0;
        int missing_num = 0;
        for(int i= 1; i<=nums.length; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[j] > i){
                    break;
                }else if(nums[j] == i){
                    count++;
                }
            }
            if(count == 0){
                missing_num = i;
            }else if(count == 2){
                 repeated_num = i;
            }
        }
        return new int[] {repeated_num, missing_num};
    }
}