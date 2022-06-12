class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int acq = 0;
        int rel = 0;
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        while(acq < nums.length){
            sum += nums[acq];
            
            while(memo.containsKey(nums[acq])){
                    sum -= nums[rel];
                    memo.remove(nums[rel]);
                    rel++;
                }
            
            if(!memo.containsKey(nums[acq])){
                memo.put(nums[acq], 1);
            }     
            
            ans = Math.max(ans, sum);
            
            acq++;
        }
        
        return ans;
    }
}