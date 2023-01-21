class Solution {
    static List<String> ans;
    public static List<String> restoreIpAddresses(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        if(n < 4 || n > 16) return ans;
        makeIpAddress(new StringBuilder(s), 0, 0);
        return ans;
    }

    private static void makeIpAddress(StringBuilder s, int idx, int count){
        if(count == 3){
            if(isValid(s.toString())){
                ans.add(new String(s.toString()));
            }
            return ;
        }

        for(int i = 1; i < 4 && i + idx < s.length(); i++){
            s.insert(idx+i, ".");
            makeIpAddress(s, idx + i + 1, count + 1);
            s.deleteCharAt(idx+i);
        }

        return ;
    }

    private static boolean isValid(String s){
        String[] ip = s.split("\\.");

        for(String str: ip){
            if(str.length() > 3 || Integer.parseInt(str) > 255 || (str.length() > 1 && str.charAt(0) == '0')) return false;
        }

        return true;
    }
}