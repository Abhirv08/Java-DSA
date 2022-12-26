class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        
        pq.add(new int[]{nums[0], 0});
        
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while(!pq.isEmpty()){
            int[] currPos = pq.poll();
            int stepSize = currPos[0];
            int index = currPos[1];
            
            if(index == n - 1) return true;
            
            for(int i = index + 1; i <= index + stepSize; i++){
                if(i < n && !vis[i]){
                    vis[i] = true;
                    pq.add(new int[]{nums[i], i});
                }
            }
            
        }
        
        return false;
    }
}