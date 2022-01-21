class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i <n; ){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int target = (nums[i]+nums[left]+nums[right]);
                if(target < 0){left++;}
                else if(target > 0){right--;}
                else{
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int tempForLeft = nums[left];
                    while(left < right && nums[left] == tempForLeft){
                        left++;
                    }
                    int tempForRight = nums[left];
                    while( left < right && nums[right] == tempForRight){
                        right--;
                    }
                }
            }
            int tempForI = nums[i];
            while(i < n && nums[i] == tempForI){
                i++;
            }
        }
        return ans;
    }
}