class Solution {
    public static String predictPartyVictory(String senate) {
        StringBuilder s = new StringBuilder(senate);

        int i = 0;
        while(true){
            char ch = s.charAt(i);
            int idx = findNearestOpposition(i+1, ch, s);
            if(idx == -1) return ch == 'R' ? "Radiant" : "Dire";
            s.deleteCharAt(idx);
            if(idx > i) i++;
            if(i == s.length()) i = 0;
        }


    }

    private static int findNearestOpposition(int idx, char ch, StringBuilder s){

        int i = idx;
        while(i < s.length()){
            if(s.charAt(i) != ch) return i;
            i++;
        }

        i = 0;
        while(i < idx - 1){
            if(s.charAt(i) != ch) return i;
            i++;
        }

        return -1;
    }
    
}