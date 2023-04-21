class Solution {
    long mod = 1000000007;
    
    long[][][] dp ;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        dp = new long[n+1][m+1][minProfit+1];
        
        for(long[][] mat: dp){
            for(long[] a: mat){
                Arrays.fill(a, -1);
            }
        }
        
        return (int) (findProfitables(n, m, 0, minProfit, group, profit, 0, 0)%mod);
    }
    
    private long findProfitables(int n, int m, int idx, int minProfit, int[] group, int[] profit, int currProfit, int currPeople){   
        if(idx == m) return currProfit >= minProfit ? 1 : 0;
        if(dp[currPeople][idx][currProfit] != -1) return dp[currPeople][idx][currProfit];
        long ans = findProfitables(n, m, idx+1, minProfit, group, profit, currProfit, currPeople)%mod; 
        if(currPeople + group[idx] <= n){
            ans += findProfitables(n, m, idx+1, minProfit, group, profit, Math.min(minProfit, currProfit + profit[idx]), currPeople + group[idx])%mod;
        }
        
        return dp[currPeople][idx][currProfit] = ans%mod;
    }
}