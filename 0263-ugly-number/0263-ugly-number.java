class Solution {
    public boolean isUgly(int n) {
        if(n == 1) return true;
        
        int q = n/5;
        while(n > 0 && q * 5 == n){
            n /= 5;
            q = n/5;
        }
        
        q = n/3;
        while(n > 0 && q * 3 == n){
            n /= 3;
            q = n/3;
        }
        
        q = n/2;
        while(n > 0 && q * 2 == n){
            n /= 2;
            q = n/2;
        }
        
        if(n == 1) return true;
        
        return false;
    }
}