class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        String cur = "";
        permute(s, 0, res, cur);
        return res;
    }
    
    private void permute(String s, int idx, List<String> res, String cur) {
        if (idx >= s.length()) {
            res.add(cur);
            return;
        }
        
        if (Character.isDigit(s.charAt(idx))) {
            // if it's digit, just continue with next idx..
            permute(s, idx + 1, res, cur + s.charAt(idx));
            
        } else {
            // if it's letter, 1 path is to use the letter as it is
            permute(s, idx + 1, res, cur + s.charAt(idx));
            
            // and another path to use letter with casing changed.
            String perm = cur + (Character.isLowerCase(s.charAt(idx))
                ? Character.toUpperCase(s.charAt(idx))
                : Character.toLowerCase(s.charAt(idx)));
            permute(s, idx + 1, res, perm);
        }
    }
}