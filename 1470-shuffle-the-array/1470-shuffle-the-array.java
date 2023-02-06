class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        
        int i = 0, j = n;
        int idx = 0;
        while(idx < nums.length){
            if(idx%2 == 0){
                ans[idx] = nums[i];
                i++;
            }else{
                ans[idx] = nums[j];
                j++;
            }
            idx++;
        }
        
        return ans;
    }
}