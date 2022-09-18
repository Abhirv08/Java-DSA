class Solution {
    public int longestContinuousSubstring(String s) {
        int i = 0;
        
        int maxLength = 0;
        char next = '0';
        int currLength = 0;
        while(i < s.length()){
            if(next == '0'){
                next = s.charAt(i);
            }
            
            if(s.charAt(i) == next){
                currLength++;
                next = (char)(next+1);
                i++;
            }else{
                next = '0';
                currLength = 0;
            }            
            maxLength = Math.max(maxLength, currLength);
        }
        
        return maxLength;
    }
}