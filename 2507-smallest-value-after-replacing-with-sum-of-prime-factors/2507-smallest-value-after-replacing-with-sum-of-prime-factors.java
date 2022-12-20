class Solution {
    public int smallestValue(int n) {
        int[] primes = getPrimes();
        
        if(primes[n] != -1){
            return n;
        }
        
        while(primes[n] == -1){
            int temp = 0;
            
            for(int i = 2; n > 1; ){
                if(n%i == 0){
                    temp += i;
                    n /= i;
                }else{
                    i++;
                    while(i < primes.length && primes[i] == -1){
                        i++;
                    }
                }
            }
            n = temp;
            if(n == 4) break;
        }
        
        return n;
    }
    
    private int[] getPrimes(){
        int[] primes = new int[100001];
        for(int i = 1; i < primes.length; i++){
            primes[i] = i;
        }
        
        primes[0] = -1;
        primes[1] = -1;
        
        int i = 2;
        while(i < primes.length){
            for(int j = 2*i; j < primes.length; j += i){
                primes[j] = -1;
            }
            
            i++;
            while(i < primes.length && primes[i] == -1){
                i++;
            }
        }
        
        return primes;
    }
}