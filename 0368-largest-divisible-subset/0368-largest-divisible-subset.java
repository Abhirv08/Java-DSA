class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] pre = new int[n];
        Arrays.fill(pre, 1);
        
        int maxCount = 0, idx = 0;;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0){
                    pre[i] = Math.max(pre[i], pre[j] + 1);
                }
            }
            if(pre[i] > maxCount){
                maxCount = pre[i];
                idx = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int lastNum = nums[idx];
        while(maxCount > 0){
            list.add(nums[idx]);
            maxCount--;
            idx--;
            while(idx >= 0 && (pre[idx] != maxCount || lastNum%nums[idx] != 0)){
                idx--;
            }
            if(idx < 0) break;
            lastNum = nums[idx];
        }
        
        if(list.size() == 0) list.add(nums[0]);
        
        return list;
    }
}