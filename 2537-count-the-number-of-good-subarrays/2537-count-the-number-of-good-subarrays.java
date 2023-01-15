class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0, j = 0;
        long count = 0;
        long ans = 0;
        while(i < n){
            if(count < k){
                int val = map.getOrDefault(nums[i], 0);
                count -= (long)(val*(val-1))/2;
                map.put(nums[i], val+1);
                val = map.get(nums[i]);
                count += (long)(val*(val-1))/2;
            }
            
            while(j < i && count >= k){
                int val = map.get(nums[j]);
                count -= (long)(val*(val-1))/2;
                map.put(nums[j], val-1);
                val = map.get(nums[j]);
                count += (long)(val*(val-1))/2;
                ans += (n-i);
                j++;
            }
            i++;
        }
        
        return ans;
    }
}