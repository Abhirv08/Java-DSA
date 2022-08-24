class Solution {
    public boolean isPowerOfThree(int n) {
        
        int i = 0;
        long num = (long)Math.pow(3, i);
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