class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        
        char[] chars = s.toCharArray();
        
        while(left < right){
            while(left < right && !isVowel(chars[left])){
                left++;
            }
            
            while(left < right && !isVowel(chars[right])){
                right--;
            }
            
            if(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            left++;
            right--;
        }
        
        return new String(chars);
//         ArrayList<Character> list = new ArrayList<>();
        
//         for(char ch: s.toCharArray()){
//             if(isVowel(ch)){
//                 list.add(ch);
//             }
//         }
        
//         int idx = list.size() - 1;
//         StringBuilder ans = new StringBuilder(s);
        
//         for(int i = 0; i < ans.length(); i++){
//             if(isVowel(ans.charAt(i))){
//                 ans.replace(i, i+1, Character.toString(list.get(idx)));
//                 idx--;
//             }
//         }
        
//         return ans.toString();
    }
    
    boolean isVowel(char ch){
        switch(ch){
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' : return true;
            default: return false;
        }
    }
    
}