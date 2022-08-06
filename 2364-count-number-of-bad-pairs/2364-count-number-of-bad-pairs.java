class Solution {
    public long countBadPairs(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        long totalPairs = getPairs(nums.length, 2);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int key = nums[i] - i;
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }
        
        long goodPairs = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > 1){
                goodPairs += getPairs(e.getValue(), 2);
            }
        }
        
        return totalPairs - goodPairs;
    }
    
    private long getPairs(int n, int r){
        if(r == n || r == 0){
            return 1;
        }
        if(r == 1){
            return n;
        }        
        
        return getPairs(n - 1, r - 1) + getPairs(n - 1, r);
    }
}