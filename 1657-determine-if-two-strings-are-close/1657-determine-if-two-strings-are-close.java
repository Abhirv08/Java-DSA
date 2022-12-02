class Solution {
    public boolean closeStrings(String w1, String w2) {
        if(w1.length() != w2.length()) return false;
        
        int n = w1.length();
        
        int[] chars1 = new int[26];
        for(char ch: w1.toCharArray()){
            chars1[ch - 'a']++;
        }
        
        int[] chars2 = new int[26];
        for(char ch: w2.toCharArray()){
            chars2[ch - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if((chars1[i] > 0 && chars2[i] == 0) || (chars2[i] > 0 && chars1[i] == 0)){
                return false;
            }
        }
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        for(int i = 25; i >= 0; i--){
            if(chars1[i] != chars2[i]){
                return false;
            }
        }
        
        return true;
    }
}