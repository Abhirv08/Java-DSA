class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> memo = new HashMap<>();
        
        int index = 0;
        
        for(int i = 0; i < key.length(); i++){
            
            if(key.charAt(i) != ' ' && !memo.containsKey(key.charAt(i))){
                memo.put( key.charAt(i), (char)(97 + index) );
                index++;
            }
        }
        
        String ans = "";
        
        for(int i = 0; i < message.length(); i++){
            char ch = message.charAt(i);
            if(ch == ' '){
                ans += ' ';
            }else{
                ans += memo.get(ch);
            }
        }
        
        return ans;
    }
}