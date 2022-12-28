class Solution {
    int mod = 1000000007;
    long[] fact = new long[100001];
    private void preCompute(){
        fact[0] = 1;
        for(int i = 1; i < 100001; i++){
            fact[i] = (i*fact[i-1])%mod;
        }
    }
    public int countAnagrams(String s) {
        preCompute();
        
        long ans = 1l;
        
        for(String word: s.split(" ")){
            ans = (ans*findCombinations(word))%mod;
        }
        
        return (int)(ans%mod);
    }
    
    private long findCombinations(String word){
        int[] letters = new int[26];
        for(char ch: word.toCharArray()){
            letters[ch - 'a']++;
        }
        
        long num = fact[word.length()]%mod;
        
        long den = 1l;
        
        for(int i = 0; i < 26; i++){
            if(letters[i] > 0){
                den = (den*(fact[letters[i]]%mod))%mod;
            }
        }
        
        long inv = calcInv(den, mod-2);
        
        return (num*inv)%mod;
    }
    
    private long calcInv(long num, int pow){
        long res = 1l;
        
        while(pow > 0){
            if(pow%2 == 1){
                res = (res*num)%mod;
            }
            
            pow >>= 1;
            num = (num*num)%mod;
        }
        
        return res%mod;
    }
}