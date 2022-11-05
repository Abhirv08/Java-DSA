class Trie{
    Trie[] children = new Trie[26];
    boolean isEnd;
    String word;
    
    public Trie(){
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        this.isEnd = false;
        this.word = "";
    }
}
class Solution {
    Trie root;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        List<String> list = new ArrayList<>();
        for(String word: words){
            insert(word);
        }
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                isPresent(board, board.length, board[0].length, row, col, root, list);
            }
        }
        
        return list;
    }    
    
    private void insert(String s){
        Trie temp = root;
        
        for(char ch: s.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new Trie();
            }            
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
        temp.word = s;
        return ;
    }
    
    private void isPresent(char[][] board, int rows, int cols, int row, int col, Trie node, List<String> list){
        
        char ch = board[row][col];
        if(ch == '.' || node.children[ch - 'a'] == null){
            return ;
        }
        
        node = node.children[ch - 'a'];
        if(node.isEnd){
            list.add(node.word);
            node.isEnd = false;
        }
        
        board[row][col] = '.';
        
        if(row > 0) isPresent(board, rows, cols, row - 1, col, node, list);
        if(col < cols - 1) isPresent(board, rows, cols, row, col + 1, node, list);
        if(row < rows - 1)isPresent(board, rows, cols, row + 1, col, node, list);
        if(col > 0) isPresent(board, rows, cols, row, col - 1, node, list);
        
        board[row][col] = ch;
        return ;
    }
    
    
}