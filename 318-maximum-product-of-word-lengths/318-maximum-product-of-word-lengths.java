class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            int a1[] = new int[26];
            for(int k = 0; k < words[i].length(); k++){
                char ch = words[i].charAt(k);
                int place = (int)(ch-'a');
                a1[place] += 1;
            }
            for(int j = i+1; j < words.length; j++){
                if(isValid(a1, words[j])){
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
    
    static boolean isValid(int[] a1, String s2){ 
        int a2[] = new int[26];
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            int place = (int)(ch-'a');
            a2[place] += 1;
        }
        
        for(int i = 0; i < 26; i++){
            if(a1[i] > 0 && a2[i] > 0){
                return false;
            }
        }
        
        return true;
    }
}