class Solution {
    public int countPrimeSetBits(int left, int right) {
        int primeSetBitNum = 0;
        while(left<=right){
            int countSetBits = 0;
            int num = left;
            while(num > 0){
                countSetBits++;
                num = num&(num-1);
            }
            if(isPrime(countSetBits)){
                primeSetBitNum++;
            }
            left++;
        }
        return primeSetBitNum;
    }
    
    static boolean isPrime(int num){
        if(num==1) return false;
        for(int i = 2; i*i <=num ; i++ ){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}