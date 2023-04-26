class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int n = heights.length;
        
        int[] smallerInLeft = new int[n];
        
        int[] smallerInRight = new int[n];
        
        st.push(new int[]{heights[0], 0});
        smallerInLeft[0] = -1;
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && st.peek()[0] >= heights[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                smallerInLeft[i] = -1;
            }else{
                smallerInLeft[i] = st.peek()[1];
            }
            st.push(new int[]{heights[i], i});
        }
        
        st.clear();
        
        st.push(new int[]{heights[n-1], n-1});
        smallerInRight[n-1] = n;
        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && st.peek()[0] >= heights[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                smallerInRight[i] = n;
            }else{
                smallerInRight[i] = st.peek()[1];
            }
            st.push(new int[]{heights[i], i});
        }
        
         System.out.println(Arrays.toString(smallerInRight));
         System.out.println(Arrays.toString(smallerInLeft));
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, (smallerInRight[i] - smallerInLeft[i] - 1)*heights[i]);
        }
        
        return ans;
    }
}