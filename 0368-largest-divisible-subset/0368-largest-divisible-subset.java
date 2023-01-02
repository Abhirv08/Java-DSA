class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] hash = new int[n];
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxIdx = 0, max = 1;
        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[i]%nums[prev] == 0 && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                maxIdx = i;
            }
        }
        
        //System.out.println(Arrays.toString(hash));
        List<Integer> list = new ArrayList<>();
        list.add(nums[maxIdx]);
        while(hash[maxIdx] != maxIdx){
            maxIdx = hash[maxIdx];            
            list.add(nums[maxIdx]);
        }
        
        return list;
    }
}