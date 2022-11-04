class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        
        while(left < right){
            while(left < right && !isVowel(s.charAt(left))){
                left++;
            }
            
            while(left < right && !isVowel(s.charAt(right))){
                right--;
            }
            
            if(left < right){
                s = s.substring(0, left) + s.charAt(right) + s.substring(left+1, right) + s.charAt(left) + s.substring(right + 1);
            }
            left++;
            right--;
        }
        
        return s;
    }
    
    boolean isVowel(char ch){
        switch(ch){
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' : return true;
            default: return false;
        }
    }
    
}