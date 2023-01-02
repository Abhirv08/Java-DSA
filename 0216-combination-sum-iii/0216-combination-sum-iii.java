class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        
        findAllCombinations(k, n, new ArrayList<>(), 0);
        
        return ans;
    }
    
    private void findAllCombinations(int k, int target, List<Integer> list, int prev){
        if(k == 0){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }            
            return ;
        }
        
        for(int i = prev + 1; i <= 9; i++){
            if(i <= target){
                list.add(i);
                findAllCombinations(k-1, target - i, list, i);
                list.remove(list.size() - 1);
            }
        }
        
        return ;
    }
}