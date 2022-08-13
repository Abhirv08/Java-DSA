class Solution {
    int n, k, wordLength, substringSize;
    HashMap<String, Integer> wordCount;
    
    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength*k;
        
        wordCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                answer.add(i);
            }
        }
        
        return answer;        
        
    }
    
    private boolean check(int i, String s){
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        
        int wordsUsed = 0;
    
        for(int j = i; j < i + substringSize; j += wordLength){
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            }else{
                break;
            }
        }
        
        return wordsUsed == k;
    }
}