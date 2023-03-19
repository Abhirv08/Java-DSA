class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        this.children = new TrieNode[26];
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        isEnd = false;
    }
}


class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String s) {
        TrieNode temp = root;
        
        for(char ch: s.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new TrieNode();
            }
            
            temp = temp.children[ch - 'a'];
        }
        
        temp.isEnd = true;
        
        return ;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        
        return search(temp, word);       
    }
    
    public boolean search(TrieNode root, String s){
        if(s.length() == 1) {
            char ch = s.charAt(0);
            if(ch == '.'){
                for(int i = 0; i < 26; i++){
                    if(root.children[i] != null && root.children[i].isEnd) return true; 
                }
                return false;
            }else{
                root = root.children[s.charAt(0) - 'a'];
                if(root == null) return false;
                return root.isEnd;
            }
        }
        
        char ch = s.charAt(0);
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(root.children[i] != null && search(root.children[i], s.substring(1))) return true; 
            }
        }else if(root.children[ch - 'a'] != null){
            if(search(root.children[ch - 'a'], s.substring(1))) return true;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */