class Solution {
    public String reverseWords(String s) {
        String[] s_arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s_arr.length; i++) {
            StringBuilder temp = new StringBuilder(s_arr[i]);
            temp.reverse();
            ans.append(temp).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}