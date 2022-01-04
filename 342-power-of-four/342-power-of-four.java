class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==2){
            return false;
        }
        long i = 1;
        while( i <= n ){
            if(i == n){
                return true;
            }
            i <<= 2;
        }
        return false;
    }
}