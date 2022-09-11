class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int num : nums){
            if((num % 2) == 0){
                memo.put(num, memo.getOrDefault(num, 0) + 1);
            }
        }
        
        int mostFrequent = Integer.MAX_VALUE;
        int freq = -1;
        
        for(Map.Entry<Integer, Integer> e : memo.entrySet()){
            
            if(freq == e.getValue()){
                mostFrequent = Math.min(e.getKey(), mostFrequent);
            }
            if(freq < e.getValue()){
                freq = e.getValue();
                mostFrequent = e.getKey();
            }          
        }
        
        return mostFrequent == Integer.MAX_VALUE ? -1 : mostFrequent;
    }
}