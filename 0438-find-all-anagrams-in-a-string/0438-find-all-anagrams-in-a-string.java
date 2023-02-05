class Solution {
    int[] charsOfP;
    public List<Integer> findAnagrams(String s, String p) {
        charsOfP = new int[26];
        for(char ch: p.toCharArray()){
            charsOfP[ch - 'a']++;
        }
        
        int len = p.length();        
        List<Integer> list = new ArrayList<>();
        
        int[] charsToCheck = new int[26];
        int acq = 0, rel = 0;
        while(acq < s.length()){
            charsToCheck[s.charAt(acq) - 'a']++;
            if(acq - rel + 1 == len){
                if(isAnagram(charsToCheck)){
                    list.add(rel);
                }
                charsToCheck[s.charAt(rel) - 'a']--;
                rel++;
            }
            acq++;
        }
        
        return list;
    }
    
    boolean isAnagram(int[] charsToCheck){        
        for(int i = 0; i < 26; i++){
            if(charsOfP[i] != charsToCheck[i]) return false;
        }
        
        return true;
    }
}