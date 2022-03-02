class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        stack.push(s.charAt(s.length()-1));
        int pointer = s.length()-2;
        while(pointer >= 0){
            if(!stack.isEmpty() && s.charAt(pointer) == stack.peek()){
                stack.pop();
            }else{
                stack.push(s.charAt(pointer));
            }
            pointer--;
        }
        while(!stack.isEmpty()){
            ans = ans + stack.pop();
        }

        return ans;
    }
}