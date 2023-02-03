class Solution {
    public String convert(String s, int n) {
        if(n == 1) return s;
        if(s.length() <= 2) return s;
        String[] zigzag = new String[n];
        Arrays.fill(zigzag, "");
        
        int i = 0, j = 0;
        int dir = 1;
        while(i < s.length()){
            zigzag[j] += s.charAt(i);
            i++;
            j += dir;
            if(j == n) {
                j -= 2;
                dir = -1;
            }
            if(j == -1) {
                j += 2;
                dir = 1;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(String str: zigzag){
            res.append(str);
        }
        
        return res.toString();
    }
}