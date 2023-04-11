class Solution {
    public String removeStars(String s) {
        int i = 0;
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '*'){
                ans.deleteCharAt(ans.length() - 1);
            }else{
                ans.append(ch);
            }
            i++;
        }
        
        return ans.toString();
    }
}