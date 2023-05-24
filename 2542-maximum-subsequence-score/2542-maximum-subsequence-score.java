class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];
        
        for(int i = 0; i < n; i++){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        
        Arrays.sort(nums, (a,b) -> b[1] - a[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long topKSum = 0;
        
        for(int i = 0; i < k; i++){
            topKSum += nums[i][0];
            pq.add(nums[i][0]);
        }
        
        long ans = topKSum*nums[k-1][1];
        
        for(int i = k; i < n; i++){
            topKSum += nums[i][0] - pq.poll();
            pq.add(nums[i][0]);            
            ans = Math.max(ans, topKSum*nums[i][1]);
        }
        
        return ans;
    }
}