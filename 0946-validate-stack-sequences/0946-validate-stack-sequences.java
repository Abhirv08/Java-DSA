class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        int i = 0;
        while(i < pushed.length){
            if(!s.isEmpty() && s.peek() == popped[j]){
                s.pop();
                j++;
            }else{                
                s.push(pushed[i]);
                i++;
            }
        }
        while(!s.isEmpty()){
            if(popped[j]!=s.pop()){
                return false;
            }
            j++;
        }
        return true;
    }
}