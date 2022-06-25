class Solution {
    public static int countAsterisks(String s) {
        int ans = 0;
        
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(!flag && s.charAt(i) == '*'){
                ans++;
            }
            if(s.charAt(i) == '|'){
                flag = !flag;
            }
        }        
        
        return ans;
    }

}