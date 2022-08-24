class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n < 3){
            return false;
        }
        int i = 0;
        long num = 3;
        while(num <= n){
            if(num == n){
                return true;
            }
            
            num = (long)Math.pow(3, i);
            i++;
        }
        
        return false;
    }
}