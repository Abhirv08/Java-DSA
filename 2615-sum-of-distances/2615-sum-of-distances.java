class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        
        long[] ans = new long[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        for(int key: map.keySet()){
            List<Integer> idxes = map.get(key);
            
            int m = idxes.size();
            if(m == 1) continue;
            
            long[] preSum = new long[m];
            long[] postSum = new long[m];
            
            preSum[0] = idxes.get(0);
            for(int i = 1; i < m; i++){
                preSum[i] = preSum[i-1] + idxes.get(i);
            }
            
            postSum[m-1] = idxes.get(m-1);
            for(int i = m-2; i >= 0; i--){
                postSum[i] = postSum[i+1] + idxes.get(i);
            }
            
            for(int i = 0; i < m; i++){
                int idx = idxes.get(i);
                
                if(i == 0){
                    ans[idx] = postSum[i+1] - (long) idx*(m-1);
                }else if(i < m - 1){
                    ans[idx] = ((long) idx*i - preSum[i-1]) + (postSum[i+1] - (long) idx*(m-1-i));
                }else{
                    ans[idx] = ((long) idx*i - preSum[i-1]);
                }
            }
        }
        
        return ans;
    }
}