class Solution {
    public long countBadPairs(int[] nums) {
        long[][] dp = new long[nums.length + 1][3];
        for(long[] a :dp){
            Arrays.fill(a, -1);
        }
        
        if(nums.length == 1){
            return 0;
        }
        long totalPairs = getPairs(nums.length, 2, dp);
        
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
                goodPairs += getPairs(e.getValue(), 2, dp);
            }
        }
        
        return totalPairs - goodPairs;
    }
    
    private long getPairs(int n, int r, long[][] dp){
        if(r == n || r == 0){
            return 1;
        }
        if(r == 1){
            return n;
        }        
        
        if( dp[n - 1][r - 1] != -1){
            return dp[n-1][r-1];
        }
        return dp[n - 1][r - 1] = getPairs(n - 1, r - 1, dp) + getPairs(n - 1, r, dp);
        
    }
}