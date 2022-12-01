class Solution {
    public boolean halvesAreAlike(String s) {
        int vowel = 0;
        for(int i = 0; i < s.length()/2; i++){
            if(isVowel(s.charAt(i))){
                vowel++;
            }
            
            if(isVowel(s.charAt(s.length()/2 + i))){
                vowel--;
            }
        }
        
        return vowel == 0;
    }
    
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        switch(ch){
            case 'a', 'e', 'i', 'o', 'u': return true;
            default: return false;
        }
    }
}