class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s, String t) {        
        return isScrambled(s, t);
    }
    
    private boolean isScrambled(String s, String t){
        int n = s.length();
        if(n != t.length()) return false;
        if(s.equals(t)) return true;
        if(n == 1) return false;
        
        String key = s + " " + t;
        if(map.containsKey(key)) return map.get(key);
        
        
        for(int i = 1; i < n; i++){            
            // swapped
            boolean swapped = isScrambled(s.substring(0, i), t.substring(n-i)) &&
                isScrambled(s.substring(i), t.substring(0, n-i));
            if(swapped) {
                map.put(key, true);
                return true;
            }
            
            // not swapped
            boolean notSwapped = isScrambled(s.substring(0, i), t.substring(0, i)) &&
                isScrambled(s.substring(i), t.substring(i));            
            if(notSwapped) {
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
}