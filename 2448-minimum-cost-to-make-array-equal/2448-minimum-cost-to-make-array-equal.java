class Solution {
    public long minCost(int[] nums, int[] cost) {
        ArrayList<int[]> list = new ArrayList<>();
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            list.add(new int[]{nums[i], cost[i]});
            sum += cost[i];
        }
        
        Collections.sort(list, (a, b) -> a[0] - b[0]);        
        
        long totalTillNow = 0;
        long median = 0L;
        int i = 0;
        
        while(totalTillNow < (sum + 1)/2 && i < nums.length){
            totalTillNow += list.get(i)[1];
            median = list.get(i)[0];
            i++;
        }
        
        long ans = 0L;
        
        for(int[] item: list){
            ans += (long)Math.abs(item[0] - median)*item[1];
        }
        
        return ans;
    }
}