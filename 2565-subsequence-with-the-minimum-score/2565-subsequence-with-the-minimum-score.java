class Solution {
    public static int minimumScore(String s, String t) {
            int len_s = s.length();
            int len_t = t.length();

            int ans = 0;
            int i = 0, j = 0;
            TreeMap<Integer, Integer> pref = new TreeMap<>();
            while(j < len_t){
                char ch = t.charAt(j);
                while(i < len_s && s.charAt(i) != ch){
                    i++;
                }

                if(i == len_s){
                    ans = len_t - j;
                    break;
                }else{
                    pref.put(i, j);
                    i++;
                }

                j++;
            }

            i = len_s - 1;
            j = len_t - 1;
            TreeMap<Integer, Integer> suff = new TreeMap<>();
            while(j >= 0){
                char ch = t.charAt(j);
                while(i >= 0 && s.charAt(i) != ch){
                    i--;
                }

                if(i < 0){
                    ans = Math.min(ans, j + 1);
                    break;
                }else{
                    suff.put(i, j);
                    i--;
                }
                j--;
            }

            for(int lower: pref.keySet()){
                Integer upper = suff.ceilingKey(lower);

                int l = pref.get(lower);
                if(upper != null && upper != lower){
                    int r = suff.get(upper);
                    if(l >= r){
                        Math.min(ans, len_t - l - 1);
                    }
                    else ans = Math.min(ans, r - l - 1);
                }else{
                    ans = Math.min(ans, len_t - l - 1);
                }
            }

            return ans;
        }   
}