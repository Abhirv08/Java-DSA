class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        
        boolean first = Character.isUpperCase(word.charAt(0));
        boolean second = Character.isUpperCase(word.charAt(1));
        
        
        if(!first && second) return false;
        for(int i = 2; i < word.length(); i++){
            boolean status = Character.isUpperCase(word.charAt(i));
            if(status != second) return false;
        }
        
        return true;
    }
}