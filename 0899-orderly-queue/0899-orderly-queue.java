class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } 
        
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 26; i++){
            while(chars[i]-- > 0){
                ans.append((char)('a' + i));
            }
        }
        
        return ans.toString();
    }
}