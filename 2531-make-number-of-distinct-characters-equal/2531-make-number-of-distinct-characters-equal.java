class Solution {
    public static boolean isItPossible(String word1, String word2) {
        int[] l1 = new int[26];
        for(char ch: word1.toCharArray()){
            l1[ch - 'a']++;
        }

        int[] l2 = new int[26];
        for(char ch: word2.toCharArray()){
            l2[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(l1[i] > 0){
                int ch1 = i;
                for(int j = 0; j < 26; j++){
                    if(l2[j] > 0){
                        int ch2 = j;
                        l1[ch1]--;
                        l1[ch2]++;
                        l2[ch2]--;
                        l2[ch1]++;
                        if(isOk(l1, l2)) return true;
                        l1[ch1]++;
                        l1[ch2]--;
                        l2[ch2]++;
                        l2[ch1]--;
                    }
                }
            }
        }

        for(int i = 0; i < 26; i++){
            if(l2[i] > 0){
                for(int j = 0; j < 26; j++){
                    if(l1[j] > 0){
                        l2[i]--;
                        l2[j]++;
                        l1[j]--;
                        l1[i]++;
                        if(isOk(l1, l2)) return true;
                        l2[i]++;
                        l2[j]--;
                        l1[j]++;
                        l1[i]--;
                    }
                }
            }
        }
        return false;
    }

    static boolean isOk(int[] l1, int[] l2){
        int c1 = 0, c2 = 0;
        for(int i = 0; i < 26; i++){
            if(l1[i] != 0) c1++;
            if(l2[i] != 0) c2++;
        }

        return c1 == c2;
    }
}