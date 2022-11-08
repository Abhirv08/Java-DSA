class Solution {
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        int end = 0;
        
        for(int curr = 0; curr < s.length(); curr++){
            if(end > 0 && Math.abs(str.charAt(curr) - str.charAt(end - 1)) == 32){
                end--;
            }else{
                str.replace(end, end+1, str.substring(curr, curr+1));
                end++;
            }
        }
        
        return str.substring(0, end).toString();
    }
}