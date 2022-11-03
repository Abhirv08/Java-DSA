class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int ans = 0;
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);            
        }
        
        boolean isOddTaken = false;
        for(String key: map.keySet()){
            String rev = new StringBuilder(key).reverse().toString();
            
            if(key.equals(rev)){
                int freq = map.get(key);
                if(freq%2 == 0){
                    ans += 2*freq;
                }else{
                    if(!isOddTaken){
                        ans += 2*(freq);
                        isOddTaken = true;
                    }else{
                        ans += 4*(freq/2);
                    }                    
                }
            }else{
                if(map.containsKey(rev)){
                    int freq = map.get(key);
                    int revFreq = map.get(rev);
                    
                    ans += 4*Math.min(freq, revFreq);
                    map.put(rev, 0);
                }
                map.put(key, 0);
            }
        }
        
        
        return ans;
    }
}