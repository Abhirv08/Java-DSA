class Trie{
    Trie[] children;
    boolean isEnd;
    
    public Trie(){
        this.children = new Trie[26];
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        this.isEnd = false;
    }
}

class Pair implements Comparable<Pair>{
    String s;
    int freq;
    public Pair(String s, int freq){
        this.s = s;
        this.freq = freq;
    }

    public int compareTo(Pair p){
        return p.freq == this.freq ? this.s.compareTo(p.s) : p.freq - this.freq;
    }
}

class Solution {
    Trie root;
    
    public List<String> topKFrequent(String[] words, int k) {
        root = new Trie();
        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(String key: map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }

        List<String> result = new ArrayList<>();

        while(k-- > 0){
            result.add(pq.remove().s);
        }

        return result;
    }
    
    public void insert(String s){
        Trie temp = root;
        
        for(char ch: s.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                temp.children[ch-'a'] = new Trie();
            }
            temp = temp.children[ch-'a'];
        }
    }
    
    public boolean hasWord(String s){
        Trie temp = root;
        
        for(char ch: s.toCharArray()){
            if(temp.children[ch-'a'] == null) return false;
            temp = temp.children[ch - 'a'];
        }
        
        return true;
    }
}