class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && h[st.peek()] > h[i]){
                int right = i;
                int cur = h[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();

                area = Math.max(area, (right - left - 1)*cur);
            }
            st.push(i); 
        }
        
        while(!st.isEmpty()){
            int right = n;
            int cur = h[st.pop()];
            int left = st.isEmpty() ? -1 : st.peek();

            area = Math.max(area, (right - left - 1)*cur);
        }
        
        return area;
    }
}