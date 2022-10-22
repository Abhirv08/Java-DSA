class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> original = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            original.put(ch, original.getOrDefault(ch, 0) + 1);
        }
        
        String ans = "";
        int count = t.length();
        for(int acq = 0, rel = 0; acq < s.length();){
            char key = s.charAt(acq);
            if(count > 0){
                if(map.containsKey(key)){
                    if(map.get(key) > 0){
                        count--;
                    }
                    map.put(key, map.get(key) - 1);
                }
                acq++;
            }
            
            while(count == 0){
                key = s.charAt(rel);
                if(ans.length() > acq - rel || ans.equals("")) ans = s.substring(rel, acq);
                if(map.containsKey(key)){
                    if(map.get(key) + 1 > 0){
                        count++;
                    }
                    map.put(key, map.get(key) + 1);
                }                    
                rel++;
            }
        }
        
        
        return ans;
    }
}