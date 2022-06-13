class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int i=0,j=0;
        while(j<nums.length) {
            // calculations
            if(q.size()==0) q.add(nums[j]);
            else {
                while(q.size()>0 && q.peekLast()<nums[j]) {
                    q.removeLast();
                }
                q.add(nums[j]);
            }
            // now move pointer j till window size == k
            if(j-i+1<k) j++;
            // if window size == k
            else{
                // find ans from calculation
                // here we have to find the max element which will be queue front
                ans[i]=q.peek();
                // now slide the window after getting ans for first window
                // first step -> remove the calculation for prev i
                if(nums[i]==q.peek()) q.removeFirst();
                // second step -> now increment i and j
                i++; j++;
            }
        }
        return ans;
    }
}