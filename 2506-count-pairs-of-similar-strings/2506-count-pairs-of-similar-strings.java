class Solution {
    public int similarPairs(String[] words) {
        HashSet<Character>[] sets = new HashSet[words.length];
        
        for(int i = 0; i < words.length; i++){
            sets[i] = new HashSet<>();
            for(int j = 0; j < words[i].length(); j++){
                sets[i].add(words[i].charAt(j));
            }
        }
        int count = 0;
        
        for(int i = 0; i < sets.length; i++){
            for(int j = i+1; j < sets.length; j++){
                if(sets[i].size() == sets[j].size() && isSimilar(sets[i], sets[j])){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isSimilar(HashSet<Character> set1, HashSet<Character> set2){
        
        for(char ch: set1){
            if(!set2.contains(ch)){
                return false;
            }
        }
        
        return true;
    }
}