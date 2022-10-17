class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        
        if(n < 26){
            return false;
        }
        
        int seen = 0;
        for(int i = 0; i < n; i++){
            int place = 1 << (sentence.charAt(i) - 'a');
            
            seen |= place;
        }
        
        return seen == (1 << 26) - 1;
    }
}