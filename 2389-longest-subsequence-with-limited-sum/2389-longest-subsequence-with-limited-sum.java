class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);     
        int n = nums.length;
        int m = queries.length;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], 1);
        }
        
        int sum = nums[0];
        for(int i = 1; i < n; i++){
            sum += nums[i];
            map.put(sum, i+1);
        }
        
        int value = 1;
        for(int key: map.keySet()){
            value = Math.max(value, map.get(key));
            map.put(key, value);
        }
        
        int[] ans = new int[m];        
        for(int i = 0; i < m; i++){
            int target = queries[i];
            Integer floorKey = map.floorKey(target);
            ans[i] = floorKey == null ? 0 : map.get(floorKey);
        }
        
        return ans;
    }
}