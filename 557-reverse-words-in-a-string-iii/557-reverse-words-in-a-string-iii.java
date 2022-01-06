class Solution {
    public String reverseWords(String s) {
        String[] s_arr = s.split(" ");
            String ans = "";
            for (int i = 0; i < s_arr.length; i++) {
                StringBuilder temp = new StringBuilder(s_arr[i]);
                temp.reverse();
                if (i==0){
                    ans += temp;
                }else{
                    ans = ans + " " +temp;
                }
            }
            return ans;
    }
}