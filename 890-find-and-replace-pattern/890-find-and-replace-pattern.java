class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) { 
        
        List<String> ans = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++){
            if(isMatching(words[i], pattern)){
                ans.add(words[i]);
            }
        }
        
        return ans;
    }
    
    private boolean isMatching(String word, String pattern){
        
        HashMap<Character, Character> forWord = new HashMap<>();
        HashMap<Character, Character> forPat = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++){
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            if(!forPat.containsKey(p)){
                forPat.put(p, w);
            }
            if(!forWord.containsKey(w)){
                forWord.put(w, p);
            }
            
            if(forPat.get(p) != w || forWord.get(w) != p){
                return false;
            }
            
        }
        
        return true;
    }
    
}