class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        
        int[] h = new int[cols];
        int maxArea = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(r == 0){
                    h[c] = (matrix[r][c] == '1' ? 1 : 0);
                }else{
                    h[c] = (matrix[r][c] == '0' ? 0 : 1 + h[c]);
                }
            }
            
            maxArea = Math.max(maxArea, maxRect(h));
        }
        
        return maxArea;
    }
    
    private int maxRect(int[] h){
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