class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = new String[26];
        //System.out.println(str[0]);
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if(str[ch-'a'] == null){
                str[ch-'a'] = word;
            }else if(!word.equals(str[ch-'a'])){
                return false;
            }
        }
        
        HashSet<String> set = new HashSet<>();
        
        for(String word: str){
            if(word != null){
                if(!set.contains(word)){
                    set.add(word);
                }else{
                    return false;
                }
            }
        }
        
        
        return true;
    }
}