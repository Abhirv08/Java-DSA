class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(isValid(words[i], words[j])){
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
    
    static boolean isValid(String s1, String s2){
        int a1[] = new int[26];
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            int place = (int)(ch-'a');
            a1[place] += 1;
        }
        
        int a2[] = new int[26];
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            int place = (int)(ch-'a');
            a2[place] += 1;
        }
        
        for(int i = 0; i < 26; i++){
            if(a1[i] > 0 && a2[i] > 0){
                return false;
            }
        }
        
        return true;
    }
}