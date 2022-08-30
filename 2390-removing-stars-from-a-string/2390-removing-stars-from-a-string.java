class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }
        
        
        StringBuilder str = new StringBuilder();
        
        int stars = 0;
        while(!st.isEmpty()){
            char ch = st.pop();
            
            if(ch == '*'){
                stars++;
            }else{
                str.insert(0, ch);                
            }
            
            while(stars > 0){
                char cha = st.pop();
                if(cha == '*'){
                    stars++;
                }else{
                    stars--;
                }
                
            }
        }
        
        return str.toString();
    }
}