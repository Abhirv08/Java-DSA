class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int ans = 0;
        
        for(int i = (1<<n) - 1; i >= 0; i--){
            boolean flag = false;
            for(int j = 0; j < n; j++){
                if((i&(1<<(n-j-1)))>>(n-j-1) == 1){
                    for(int c = 0; c < n; c++){
                        if(statements[j][c] == 2) continue;

                        if((i&(1<<(n-c-1)))>>(n-c-1) == 1 && statements[j][c] == 0){
                            flag = true;
                            break;
                        }

                        if((i&(1<<(n-c-1)))>>(n-c-1) == 0 && statements[j][c] == 1){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag) break;
            }            
            if(!flag) ans = Math.max(ans, Integer.bitCount(i));
        }
        
        return ans;
    }
}