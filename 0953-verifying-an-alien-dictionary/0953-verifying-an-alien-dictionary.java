class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] val = new int[26];
        for(int i = 0; i < order.length(); i++){
            val[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 1; i < words.length; i++){
            String s1 = words[i-1];
            String s2 = words[i];
            
            int p1 = 0, p2 = 0;
            while(p1 < s1.length() && p2 < s2.length()){
                char ch1 = s1.charAt(p1);
                char ch2 = s2.charAt(p2);
                
                if(val[ch1 - 'a'] < val[ch2 - 'a']) break;
                
                if(val[ch1 - 'a'] > val[ch2 - 'a']) return false;
                
                p1++;
                p2++;
            }
            
            if(p1 != s1.length() && p2 == s2.length()) return false;
        }
        
        return true;
    }
}