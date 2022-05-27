class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helping(nums, k) - helping(nums, k-1);
    }
    
    public int helping(int[] nums, int k){
        int acq = 0;
        int rel = 0;
        int subarrays = 0;
        int distinct = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(; acq < nums.length; acq++){
            int curr = nums[acq];
            if(!memo.containsKey(curr)){
                distinct++;
                memo.put(curr, 1);
            }else{
                memo.put(curr, memo.get(curr) + 1);
            }
            
            while(distinct > k){
                if(memo.get(nums[rel]) > 1){
                    memo.put(nums[rel], memo.get(nums[rel]) -1);
                }else{
                    memo.remove(nums[rel]);
                    distinct--;
                }
                rel++;
            }
            
            subarrays += (acq-rel+1);
        }
        return subarrays;
    }
}