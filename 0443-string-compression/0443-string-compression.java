class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        StringBuilder s = new StringBuilder();
        
        while(i < n){
            char ch = chars[i];
            int count = 0;
            while(i < n && chars[i] == ch){
                i++;
                count++;
            }
            
            s.append(ch);
            if(count > 1){
                s.append(count);
            }
        }
        
        for(i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i);
        }
        
        return s.length();
    }
}