class Solution {
    HashSet<String> set;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        
        if(!set.contains(endWord)){
            return 0;
        }
        
        return bfs(beginWord, endWord);
    }
    
    private int bfs(String beginWord, String endWord){
        Queue<String> q = new LinkedList<>();
        int depth = 1;
        q.add(beginWord);
        int qsize = q.size();
        boolean flag = false;
        line : while(!q.isEmpty() && !flag){
            String currWord = q.poll();
            qsize--;

            for(int i = 0; i < currWord.length(); i++){
                for(int j = 0; j < 26; j++){
                    if((char)('a' + j) != currWord.charAt(i)){
                        String formed = currWord.substring(0, i) + (char)('a' + j) + currWord.substring(i + 1);
                        if(set.contains(formed)){
                            q.add(formed);
                            set.remove(formed);
                            if(formed.equals(endWord)){
                                flag = true;
                                continue line;
                            }
                        }
                    }
                }
            }


            if(qsize == 0){
                depth++;
                qsize = q.size();
            }
        }

        return flag ? depth + 1 : 0;
    }
}