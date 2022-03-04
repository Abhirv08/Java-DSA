class Solution {
    public int minAddToMakeValid(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < s.length()){
            if(s.substring(i, i+1).equals("(")){
                st.push(")");
            }else{
                if(!st.isEmpty() && s.substring(i, i+1).equals(st.peek())){
                    st.pop();
                }else{
                    st.push("(");
                }
            }
            
            i++;
        }
        int counter = 0;
        while(!st.isEmpty()){
            counter++;
            st.pop();
        }
        return counter;
    }
}