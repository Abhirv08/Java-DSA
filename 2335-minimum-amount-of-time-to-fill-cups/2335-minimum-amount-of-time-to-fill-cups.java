class Solution {
    public int fillCups(int[] amount) {
        
        
        int n = amount.length;
        int ans = 0;
        int i = n - 1;
        while(i >= 0){
            Arrays.sort(amount);
            
            if(amount[i] > 0){
                if(amount[i-1] > 0){
                    amount[i]--;
                    amount[i-1]--;
                }else{
                    amount[i]--;
                }
                ans += 1;
            }else{
                break;
            }
            
        }
        
        return ans;
    }
}