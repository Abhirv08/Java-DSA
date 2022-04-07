class Solution {
    public boolean isAnagram(String s, String t) {
        char[] countfors = new char[26];
        for(int i = 0; i < s.length(); i++){
            countfors[s.charAt(i)-'a']++;
        }
        char[] countfort = new char[26];
        for(int i = 0; i < t.length(); i++){
            countfort[t.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(countfort[i] < countfors[i] || countfort[i] > countfors[i]){
                return false;
            }
        }
        return true;
    }
}