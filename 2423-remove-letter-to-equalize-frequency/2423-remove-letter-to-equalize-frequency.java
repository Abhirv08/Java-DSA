class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                freq[i]--;
                if(isCorrect(freq)){
                    return true;
                }
                freq[i]++;
            }
        }
        
        return false;
    }
    
    private boolean isCorrect(int[] freq){
        int firstCount = 0;
        
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                if(firstCount == 0){
                    firstCount = freq[i];
                }
                
                if(freq[i] != firstCount){
                    return false;
                }
            }
        }
        
        return true;
    }
    
}