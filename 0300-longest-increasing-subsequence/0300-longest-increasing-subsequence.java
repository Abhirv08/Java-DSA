class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int idx = findIdx(nums[i], list);
            if(idx < list.size()) list.remove(idx);
            list.add(idx, nums[i]);
        }
        
        return list.size();
    }
    
    private int findIdx(int target, List<Integer> list){
        if(list.size() == 0) return 0;
        
        int l = 0, r = list.size() - 1;
        while(l <= r){
            int m = l + (r-l)/2;
            
            if(list.get(m) == target){
                l = m;
                break;
            }            
            if(list.get(m) < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        
        return l;
    }
}