class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> nums_copy = new ArrayList<>();
        
        for(int num : nums){
            nums_copy.add(num);
        }
        
        Collections.sort(nums_copy);
        
        List<Integer> ans = new ArrayList<>();
        
        for(int num : nums){
            ans.add(getIndex(nums_copy, num));
        }
        
        return ans;
    }
    
    private int getIndex(List<Integer> list, int target){
        int start = 0;
        int end = list.size() -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(list.get(mid) == target){
                while(mid -1 >= 0 && list.get(mid -1) == target){
                    mid--;
                }
                list.remove(mid);
                return mid;
            }else if(list.get(mid) > target){
                end = mid -1;
            }else{
                start = mid +1;
            }
            
        }
        
        return -1;
    }
}