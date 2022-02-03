class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         List<Integer> ans = new ArrayList<>();
        
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                ans.add(i+1);
            }
        }
        return ans;
    }
    
    static void cyclicSort(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correct_index = nums[i]-1;
            if( nums[correct_index] != nums[i] ){
                int temp = nums[correct_index];
                nums[correct_index] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }
        
    }
}