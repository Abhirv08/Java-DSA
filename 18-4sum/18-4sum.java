class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0){
            return ans;
        }
         Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; ){
            for(int j = i+1; j < n; ){
                int left = j+1;
                int right = n-1;
                int target2 = target - (nums[i]+nums[j]);
                while(left < right){
                    int target3 = target2 - nums[left] - nums[right];
                    if(target3 > 0){ left++;}
                    else if(target3 < 0) {right--;}
                    else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
                int tempForJ = nums[j];
                while(j < n && nums[j] == tempForJ){
                    j++;
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