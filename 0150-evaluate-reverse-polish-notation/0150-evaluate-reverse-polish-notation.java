class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String s: tokens){
            if(isOperator(s)){
                int num1 = st.pop();
                int num2 = st.pop();
                if(s.equals("+")){
                    st.push(num1 + num2);
                }else if(s.equals("-")){
                    st.push(num2 - num1);
                }else if(s.equals("*")){
                    st.push(num1 * num2);
                }else{
                    st.push(num2 / num1);
                }
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        
        return st.pop();
    }
    
    private boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        
        return false;
    }
}