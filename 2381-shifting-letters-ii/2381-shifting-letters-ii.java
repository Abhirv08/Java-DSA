class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] str = s.toCharArray();
        
        int[] prefixArr = new int[s.length() + 1];
        
        for(int[] shift : shifts){            
            prefixArr[shift[0]] += (shift[2] == 0 ? -1 : 1);
            prefixArr[shift[1] + 1] += (shift[2] == 0 ? 1 : -1);
        }
        
        int prefixSum = 0;
        for(int i = 0; i < s.length(); i++){
            prefixSum += prefixArr[i];
            int newChar = (s.charAt(i) - 'a' + prefixSum) % 26;
            
            if(newChar < 0){
                newChar += 26;
            }
            str[i] = (char)('a' + newChar);
        }
        
        return new String(str);
    }
}