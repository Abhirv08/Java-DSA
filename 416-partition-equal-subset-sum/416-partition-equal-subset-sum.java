class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if( (sum&1)==1 ) return false;
        return subsetPossible(nums, 0, sum/2, new HashMap<String, Boolean>());
    }
    
    static boolean subsetPossible(int[] nums, int index, int target, HashMap<String, Boolean> map){
        if(target == 0) return true;
        if(index == nums.length) return false;
        
        String currentKey = Integer.toString(index) + "-" + Integer.toString(target);
        
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        boolean numTaken = false;
        if(target >= nums[index])
            if(numTaken = subsetPossible(nums, index+1, target-nums[index], map)){
                return true;
            }
        
        boolean numNotTaken = subsetPossible(nums, index+1, target, map);
        
        map.put(currentKey, numTaken || numNotTaken);
        
        return numNotTaken;
    }
}