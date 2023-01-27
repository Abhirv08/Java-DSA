class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
        boolean isAdded;
    }
    
    TrieNode root;
    List<String> ans;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        ans = new ArrayList<>();
        
        for(String word: words){
            insert(word);
        }
        
        searchForConcatenated(root);
        
        return ans;
    }
    
    private void searchForConcatanation(TrieNode curr, TrieNode newWord){
        if(curr.word != null && newWord.word != null){
            if(!curr.isAdded) ans.add(curr.word);
            curr.isAdded = true;
        }
        
        if(newWord.word != null){
            searchForConcatanation(curr, root);
        }
        
        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null && newWord.children[i] != null){
                searchForConcatanation(curr.children[i], newWord.children[i]);
            }
        }        
        
        return ;
    }
    
    private void searchForConcatenated(TrieNode curr){
        if(curr.word != null){
            searchForConcatanation(curr, root);
        }
        
        for(TrieNode child: curr.children){
            if(child != null){
                searchForConcatenated(child);
            }
        }
        
        return ;
    }
    
    private void insert(String s){
        TrieNode temp = root;
        
        for(char ch: s.toCharArray()){
            if(temp.children[ch-'a'] == null){
                temp.children[ch-'a'] = new TrieNode();
            }
            temp = temp.children[ch-'a'];
        }
        temp.word = s;
        return ;
    }
}