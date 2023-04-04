class Solution {
    public int partitionString(String s) {
        int count = 0;
        
        int[] chars = new int[26];
        int i = 0;
        while(i < s.length()){          
            while(i < s.length() && chars[s.charAt(i) - 'a'] == 0){
                chars[s.charAt(i) - 'a']++;
                i++;
            }
            count++;
            chars = new int[26];
        }
        
        return count;
    }
}