class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[26];
        updateMorseCode(morseCodes);
        
        HashMap<String, Integer> set = new HashMap<>();
        
        for(String word : words){
            StringBuilder morseCode = new StringBuilder();
            
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                morseCode.append(morseCodes[ch - 'a']);
            }
            
            set.put(morseCode.toString(), set.getOrDefault(morseCode.toString(), 0) + 1);
        }
        
        
        return set.size();
    }
    
    private void updateMorseCode(String[] morseCodes){
        morseCodes[0] = ".-";
        morseCodes[1] = "-...";
        morseCodes[2] = "-.-.";
        morseCodes[3] = "-..";
        morseCodes[4] = ".";
        morseCodes[5] = "..-.";
        morseCodes[6] = "--.";
        morseCodes[7] = "....";
        morseCodes[8] = "..";
        morseCodes[9] = ".---";
        morseCodes[10] = "-.-";
        morseCodes[11] = ".-..";
        morseCodes[12] = "--";
        morseCodes[13] = "-.";
        morseCodes[14] = "---";
        morseCodes[15] = ".--.";
        morseCodes[16] = "--.-";
        morseCodes[17] = ".-.";
        morseCodes[18] = "...";
        morseCodes[19] = "-";
        morseCodes[20] = "..-";
        morseCodes[21] = "...-";
        morseCodes[22] = ".--";
        morseCodes[23] = "-..-";
        morseCodes[24] = "-.--";
        morseCodes[25] = "--..";
        
    }
}