class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if((nums[i]&1) == 1) nums[i] *= 2;
            min = Math.min(min, nums[i]);
            pq.add(nums[i]);
        }
        
        int diff = Integer.MAX_VALUE;
        while(pq.peek()%2 == 0){
            int max = pq.poll();
            diff = Math.min(diff, max - min);
            min = Math.min(min, max/2);
            pq.add(max/2);
        }
        
        return Math.min(pq.peek() - min, diff);
    }
}