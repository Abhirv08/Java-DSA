class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ip = new ArrayList<>();
        subsets(nums, 0, ip, ans);
        return ans;
    }
    
    private void subsets(int[] nums, int ci, List<Integer> ip, List<List<Integer>> ans){
        if(ci == nums.length){            
            List<Integer> temp = new ArrayList<>();
            for(int num : ip) temp.add(num);
            ans.add(temp);
            return;
        }       
        
        ip.add(nums[ci]);
        subsets(nums, ci+1, ip, ans);        
        ip.remove(ip.size()-1);
        subsets(nums, ci+1, ip, ans);
        return;
    }
} 