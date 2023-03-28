class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return minCost(days, 0, costs, dp);
    }
    
    private int minCost(int[] days, int i, int[] costs, int[] dp){
        if(i == days.length) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        // if 1 day pass is taken
        int oneDay = costs[0] + minCost(days, i+1, costs, dp);
        
        // if 7 days pass is taken
        int sevenDays = costs[1];
        int temp_i = i;
        
        while(temp_i < days.length && days[temp_i] - days[i] < 7){
            temp_i++;
        }
        
        sevenDays += minCost(days, temp_i, costs, dp);
        
        // if 30 days pass is taken
        int thirtyDays = costs[2];
        temp_i = i;
        
        while(temp_i < days.length && days[temp_i] - days[i] < 30){
            temp_i++;
        }
        
        thirtyDays += minCost(days, temp_i, costs, dp);
        
        return dp[i] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }
}