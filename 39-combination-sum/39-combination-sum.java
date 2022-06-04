class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currSubArr = new ArrayList<>();
        combinationSum(candidates, currSubArr , target, ans, 0);
        return ans;
    }
    
    private void combinationSum(int[] cand, ArrayList<Integer> currSubArr, int target, List<List<Integer>> ans, int ci){
        if(target == 0){
            if(!ans.contains(currSubArr)){
                ans.add(new ArrayList<>(currSubArr));
            }
            return;
        }
        if(target < 0 || ci >= cand.length){
            return;
        }
        
        if(cand[ci] <= target){
            currSubArr.add(cand[ci]);
            combinationSum(cand, currSubArr, target - cand[ci], ans, ci);
            currSubArr.remove(currSubArr.size() - 1);
        }
        combinationSum(cand, currSubArr, target, ans, ci+1);
        
        return ;
    }
}