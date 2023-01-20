class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> set;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        subsequences(nums, 0, -101, new ArrayList<>());
        
        return ans;
    }
    
    private void subsequences(int[] nums, int idx, int prev, List<Integer> list){
        if(idx == nums.length){
            if(list.size() >= 2 && !set.contains(list)){
                ans.add(new ArrayList<>(list));
                set.add(new ArrayList<>(list));
            }
            
            return ;
        }
        
        subsequences(nums, idx+1, prev, list);
        
        if(nums[idx] >= prev){
            list.add(nums[idx]);
            subsequences(nums, idx+1, nums[idx], list);
            list.remove(list.size() - 1);
        }
        
        return ;
    }
}