class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return false;
        }
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int num : nums){
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        
        HashMap<Integer, Integer> end = new HashMap<>();
        
        for(int num : nums){
            if(memo.get(num) == 0) continue;           
            
            
            memo.put(num, memo.get(num) - 1);
            if(end.get(num - 1) != null && end.get(num - 1) > 0){ 
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }else if(memo.getOrDefault(num + 1, 0) > 0 && memo.getOrDefault(num + 2, 0) > 0){
                memo.put(num + 1, memo.get(num + 1) - 1);
                memo.put(num + 2, memo.get(num + 2) - 1);
                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);                    
            }else{
                return false;
            }
        }
        return true;
    }
}