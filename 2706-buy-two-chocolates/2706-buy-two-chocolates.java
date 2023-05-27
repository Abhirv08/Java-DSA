class Solution {
    public int buyChoco(int[] prices, int money) {
        int f = 101, s = 101;
        
        for(int p: prices){
            if(p <= f){
                s = f;
                f = p;
            }else if(p <= s){
                s = p;
            }
        }        
        
        int diff = money - s - f;
        
        if(diff < 0) return money;
        
        return diff;
    }
}