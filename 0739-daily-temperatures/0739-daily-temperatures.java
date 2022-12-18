class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{tmp[tmp.length - 1], tmp.length - 1});
        
        int[] ans = new int[tmp.length];
        
        for(int i = tmp.length - 2; i >= 0; i--){
            while(!st.isEmpty() && tmp[i] >= st.peek()[0]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                ans[i] = st.peek()[1] - i;
            }
            
            st.push(new int[] {tmp[i], i});
        }
        
        return ans;
    }
}