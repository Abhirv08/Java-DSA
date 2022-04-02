class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){                
                start++;
                end--;
            }else{
               return isPalindrome(s.substring(start, end)) || isPalindrome(s.substring(start+1, end+1));
            }
        }
        
        return true;
        
    }
    
    boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){                
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}