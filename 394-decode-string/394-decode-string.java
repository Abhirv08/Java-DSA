class Solution {    
     int i = 0;
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        while(i < s.length() && s.charAt(i) != ']'){
            if(Character.isDigit(s.charAt(i))){
                int k = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    k = k*10 + s.charAt(i++) -'0';
                }i++;
                String temp = decodeString(s);
                while(k-- > 0){
                    ans.append(temp);
                }i++;
            }else{
                ans.append(s.charAt(i++));
            }            
        }
        return ans.toString();
    }
    
}