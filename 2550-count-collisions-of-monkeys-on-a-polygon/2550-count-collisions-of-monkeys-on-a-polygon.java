class Solution {
    long mod = 1000000007;
    public int monkeyMove(int n) {
        return (int)((mod + calcPow(2, n) - 2)%mod);
    }
    
    long calcPow(long num, long pow){
        long res = 1l;
        while(pow > 0){
            if((pow&1) == 1){
                res = (res*num)%mod;
            }
            pow >>= 1;
            num = (num*num)%mod;
        }
        
        return (res)%mod;
    }
}