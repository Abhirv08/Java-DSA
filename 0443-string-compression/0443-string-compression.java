class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int k = 0;
        
        while(i < n){
            char ch = chars[i];
            int count = 0;
            while(i < n && chars[i] == ch){
                i++;
                count++;
            }
            
            chars[k] = ch;
            k++;
            if(count > 1){
                String c = Integer.toString(count);
                for(char num: c.toCharArray()){
                    chars[k] = num;
                    k++;
                }
            }
        }
        
        return k;
    }
}