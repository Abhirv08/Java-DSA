class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        
        if(n < 26){
            return false;
        }
        
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(sentence.charAt(i));
        }
        
        return set.size() == 26;
    }
}