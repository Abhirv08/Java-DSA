class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        if(s1.equals(s2)) return true;

        int start = 0;
        int end = 0;
        while(end < s2.length()+1){
            if(s2.substring(start, end).length() < s1.length()){
                end++;
            }else{
                int[] s1map = new int[26];
                for(int i = 0; i < s1.length(); i++){
                    s1map[s1.charAt(i) - 'a']++;
                }
                if(isPermutation(s1map, s2.substring(start, end))){
                    return true;
                }
                start++; end++;
            }
        }
        return false;
    }

    static boolean isPermutation(int[] arr, String s){
        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i) - 'a'] > 0){
                arr[s.charAt(i) - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] > 0){
                return false;
            }
        }
        return true;
    }
    
}