class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] countfornote = new char[26];
        for(int i = 0; i < ransomNote.length(); i++){
            countfornote[ransomNote.charAt(i)-'a']++;
        }
        char[] countformag = new char[26];
        for(int i = 0; i < magazine.length(); i++){
            countformag[magazine.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(countformag[i] < countfornote[i]){
                return false;
            }
        }
        return true;
    }
}