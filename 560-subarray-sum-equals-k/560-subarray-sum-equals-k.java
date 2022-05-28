class Solution {
    public int subarraySum(int[] nums, int k) {
        int subarrays = 0;
        int psum = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        for(int i = 0; i <nums.length; i++){
            psum += nums[i];
            
            if(memo.containsKey(psum - k)){
               subarrays += memo.get(psum-k);
               
            }
            if(!memo.containsKey(psum)){
               memo.put(psum, 1);
            }else{
                memo.put(psum, memo.get(psum)+1);
            }       
            
        }
        return subarrays;
    }
}