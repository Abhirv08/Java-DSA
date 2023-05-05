class Solution {
    public int maxVowels(String s, int k) {
        int acq = 0, rel = 0;
        
        int count = 0, max = 0;
        while(acq < s.length()){
            if(isVowel(s.charAt(acq))) count++;
            if(acq - rel + 1 > k){
                if(isVowel(s.charAt(rel))) count--;
                rel++;
            }
            acq++;
            max = Math.max(count, max);
        }
        
        return max;
    }
    
    private boolean isVowel(char ch){
        switch(ch){
            case 'a', 'e', 'i', 'o', 'u' : return true;
                
            default: return false;
        }
    }
}