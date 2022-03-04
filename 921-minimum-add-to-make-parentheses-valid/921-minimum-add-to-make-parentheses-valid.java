class Solution {
    public int minAddToMakeValid(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        int counter = 0;
        while(i < s.length()){
            if(s.substring(i, i+1).equals("(")){
                st.push(")");
                counter++;
            }else{
                if(!st.isEmpty() && s.substring(i, i+1).equals(st.peek())){
                    st.pop();
                    counter--;
                }else{
                    st.push("(");
                    counter++;
                }
            }            
            i++;
        }
        return counter;
        
//         int ans = 0, bal = 0;
//         for (int i = 0; i < s.length(); ++i) {
//             bal += s.charAt(i) == '(' ? 1 : -1;
//             // It is guaranteed bal >= -1
//             if (bal == -1) {
//                 ans++;
//                 bal++;
//             }
//         }

//         return ans + bal;
    }
}