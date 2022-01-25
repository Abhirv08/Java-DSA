class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
      List<Integer> ans = new ArrayList<>();
        int k = pat.length();
        int[] pat_map = new int[26];
        for (int i = 0; i < k; i++) {
            char ch = pat.charAt(i);
            pat_map[ch-'a'] += 1;
        }
        int[] txt_map = new int[26];
        int l = 0;
        int r = 0;
        while(r < txt.length()){
            txt_map[txt.charAt(r) - 'a'] += 1;
            if (r-l+1 < k){
                r++;
            }else if (r-l+1 == k){
                if (isValid(pat_map, txt_map)){
                    ans.add(l);
                }
                txt_map[txt.charAt(l)-'a'] -= 1;
                l++;
                r++;
            }
        }
        return ans;
    }

    static boolean isValid(int[] pat_map, int[] txt_map){
        for (int i = 0; i < 26; i++) {
            if (pat_map[i]!=txt_map[i]){
                return false;
            }
        }
        return true;
    }
}