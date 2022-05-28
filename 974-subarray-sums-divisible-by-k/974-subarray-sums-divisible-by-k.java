class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int psum  = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);        
        int subarrays = 0;
        for(int i = 0; i < nums.length; i++){
            psum += nums[i];
            int remainder = ((psum % k) + k) % k;
            if(memo.containsKey(remainder)){
                subarrays += memo.get(remainder);
                memo.put(remainder, memo.get(remainder)+1);
            }else{
                memo.put(remainder, 1);
            }
            
        }
        return subarrays;
    }
}