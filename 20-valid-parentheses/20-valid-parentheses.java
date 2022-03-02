class Solution {
    public boolean isValid(String s) {
        if(s.substring(0, 1).equals(")") || s.substring(0, 1).equals("]") || s.substring(0, 1).equals("}")){
            return false;
        }
        Stack<String> stack = new Stack<>();
        int pointer = 0;
        while(pointer < s.length()){
            String checker = s.substring(pointer, pointer+1);
            if(checker.equals("(")){
                stack.push(")");
            }else if(checker.equals("[")){
                stack.push("]");
            }else if(checker.equals("{")){
                stack.push("}");
            }else{
                if(!stack.isEmpty() && checker.equals(stack.peek())){
                    stack.pop();
                }else{
                    return false;
                }
            }
            pointer++;
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}