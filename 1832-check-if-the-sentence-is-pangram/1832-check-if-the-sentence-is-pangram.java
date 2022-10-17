class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        
        if(n < 26){
            return false;
        }
        
        int[] letters = new int[26];
        
        for(char ch : sentence.toCharArray()){
            letters[ch - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(letters[i] == 0) return false;
        }
        
        return true;
    }
}