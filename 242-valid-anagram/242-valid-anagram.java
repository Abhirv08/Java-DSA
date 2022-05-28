class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> memo = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(memo.containsKey(ch)){
               memo.put(ch, memo.get(ch) + 1); 
            }else{
                memo.put(ch, 1);
            }
        }
        
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(memo.containsKey(ch)){
                memo.put(ch, memo.get(ch) - 1); 
                if(memo.get(ch) == 0){
                    memo.remove(ch);
                }
            }else{
                return false;
            }
        }
        if(memo.size() != 0){
            return false;
        }
        return true;
    }
}