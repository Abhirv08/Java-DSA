class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < amount + 1; j++){
                if(i == 0){
                    if(j%coins[0] == 0) curr[j] = 1;
                }else{
                    int notTaken = prev[j];
                    int taken = 0;
                    if(j >= coins[i]){
                        taken = curr[j - coins[i]];
                    }
                    curr[j] = notTaken + taken;
                }
            }
            prev = curr;
        }
        
        return prev[amount];
    }
}