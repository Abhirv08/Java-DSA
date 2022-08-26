class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s = Integer.toString(n);
        int[] digits = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            digits[i] = s.charAt(i) - '0';
        }
        
        return permutations(digits, 0);        
    }
    
    private boolean permutations(int[] digits, int start){
        if(digits.length == start) return isPowerOfTwo(digits);
        
        for(int  i = start; i < digits.length; i++){
            swap(digits, start, i);
            
            if(permutations(digits, start + 1)){
                return true;
            }
            
            swap(digits, start, i);
        }
                  
        return false;
    }
                  
    private boolean isPowerOfTwo(int[] digits){
        if(digits[0] == 0) return false;
        
        int n = 0;
        for(int i = 0; i < digits.length; i++){
            n = n * 10 + digits[i];
        }
        
        while(n > 0 && (n & 1) == 0){
            n >>= 1;
        }
        
        return n == 1;
    }
    
    private void swap(int[] digits, int i, int j){
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}