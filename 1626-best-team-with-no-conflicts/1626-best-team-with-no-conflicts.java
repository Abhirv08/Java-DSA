class Solution {
    int[][] dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        
        int[][] player = new int[n][2];
        
        for(int i = 0; i < n; i++){
            player[i][0] = scores[i];
            player[i][1] = ages[i];
        }
        
        Arrays.sort(player, (a,b) -> b[1]-a[1] == 0? a[0] - b[0]:a[1] - b[1]);
        dp = new int[n][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return  bestScore(player, n, 0, -1);
        
    }
    
    int bestScore(int[][] person, int n, int idx, int prev){
        if(idx == n) return 0;
        
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        
        if(prev == -1 || person[idx][0] >= person[prev][0]){
            int take = person[idx][0] + bestScore(person, n, idx+1, idx);
            int notTake = bestScore(person, n, idx+1, prev);
            
            return dp[idx][prev+1] = Math.max(take, notTake);
        }
        
        return dp[idx][prev+1] = bestScore(person, n, idx+1, prev);
    } 
}