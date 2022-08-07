class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        int ans = 0;
        int i = 0;
        while(i < nums.length){
            if(set.contains(nums[i] + diff)){
                if(set.contains(nums[i] + 2*diff)){
                    ans++;
                }
            }
            i++;
        }
        
        return ans;
    }
}