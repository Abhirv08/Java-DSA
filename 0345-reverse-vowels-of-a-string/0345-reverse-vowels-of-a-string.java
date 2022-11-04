class Solution {
    public String reverseVowels(String s) {
//         int left = 0, right = s.length() - 1;
        
//         while(left < right){
//             while(left < right && !isVowel(s.charAt(left))){
//                 left++;
//             }
            
//             while(left < right && !isVowel(s.charAt(right))){
//                 right--;
//             }
            
//             if(left < right){
//                 s = s.substring(0, left) + s.charAt(right) + s.substring(left+1, right) + s.charAt(left) + s.substring(right + 1);
//             }
//             left++;
//             right--;
//         }
        
//         return s;
        
        ArrayList<Character> list = new ArrayList<>();
        
        for(char ch: s.toCharArray()){
            if(isVowel(ch)){
                list.add(ch);
            }
        }
        
        int idx = list.size() - 1;
        StringBuilder ans = new StringBuilder(s);
        
        for(int i = 0; i < ans.length(); i++){
            if(isVowel(ans.charAt(i))){
                ans.replace(i, i+1, Character.toString(list.get(idx)));
                idx--;
            }
        }
        
        return ans.toString();
    }
    
    boolean isVowel(char ch){
        switch(ch){
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' : return true;
            default: return false;
        }
    }
    
}