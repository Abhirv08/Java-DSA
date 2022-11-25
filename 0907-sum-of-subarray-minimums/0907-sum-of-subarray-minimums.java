class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i <= arr.length; i++){
            while(!st.empty() && (i == arr.length || arr[i] <= arr[st.peek()])){
                int mid = st.pop();
                int prev = st.empty() ? -1 : st.peek();
                
                long count = (i - mid)*(mid - prev)%1000000007;
                ans += (arr[mid]*count)%1000000007;
                ans %= 1000000007;
            }
            st.push(i);
        }
        
        
        return (int)ans%1000000007;
    }
}