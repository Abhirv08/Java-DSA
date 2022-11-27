class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long ans = 0;
        
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for(int i = 0; i < n; i++){
            map[i] = new HashMap<>(i);
            for(int j = 0; j < i; j++){
                long delta = (long)nums[i] - (long)nums[j];
                
                if(delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE){
                    continue;
                }
                
                int diff = (int) delta;
                int previouslyFound = map[j].getOrDefault(diff, 0);
                int curr = map[i].getOrDefault(diff, 0);
                
                map[i].put(diff, previouslyFound + curr + 1);
                ans += previouslyFound;
            }
        }
        
        return (int)ans;
    }
}