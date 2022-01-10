class Solution {
    public int singleNonDuplicate(int[] nums) {
        int nonrepeated  = 0;
        for(int i = 0; i< nums.length; i++){
            nonrepeated ^= nums[i];
        }
        return nonrepeated;
    }
}