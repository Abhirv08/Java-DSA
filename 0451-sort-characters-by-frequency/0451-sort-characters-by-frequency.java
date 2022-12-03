class Pair{
    char ch;
    int freq;
    
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        Pair[] a = new Pair[map.size()];
        
        int i = 0;
        for(char key: map.keySet()){
            a[i] = new Pair(key, map.get(key));
            i++;
        }
        
        Arrays.sort(a, (x, y) -> y.freq - x.freq);
        
        StringBuilder ans = new StringBuilder();
        
        for(i = 0; i < a.length; i++){
            char ch = a[i].ch;
            int freq = a[i].freq;
            
            while(freq-- > 0){
                ans.append(ch);
            }
        }
        
        return ans.toString();        
    }
}