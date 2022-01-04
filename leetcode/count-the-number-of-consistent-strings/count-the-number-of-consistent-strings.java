class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int allowed_string = 0;
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (allowed.contains(String.valueOf(words[i].charAt(j)))){
                    count++;
                }else{
                    break;
                }
            }
            if (count == words[i].length()){
                allowed_string++;
            }
        }
        return allowed_string;    
    }
}