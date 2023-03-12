class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        
        HashMap<Long, Long> map = new HashMap<>();
        
        long xor = 0;
        map.put(xor, 1l);
        
        for(int i = 0; i < n; i++){
            xor ^= nums[i];
            
            map.put(xor, map.getOrDefault(xor, 0l) + 1);
        }
        
        long ans = 0;
        
        for(long val: map.values()){
            ans += (val*(val - 1))/2;
        }
        
        return ans;
    }
}