class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return maxTheft(nums, 0, map);
    }
    
    private int maxTheft(int[] nums, int currentHouse, HashMap<Integer, Integer> map){
        if(currentHouse >= nums.length) return 0;
        
        int currentKey = currentHouse;
        
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int loot1 = nums[currentKey] + maxTheft(nums, currentKey+2, map);
        int loot2 = maxTheft(nums, currentKey+1, map);
        
        int amountLooted = Math.max(loot1, loot2);
        map.put(currentKey, amountLooted);
        
        
        return amountLooted;
    }
    
}