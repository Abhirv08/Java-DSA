class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {                
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(map.containsKey(sum%k)){
                if(i > map.get(sum%k)) return true;
            }else{
                map.put(sum%k, i+1);
            }
        }
        
        return false;        
    }
}