class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        
        HashMap<Integer, Integer> am = new HashMap<>();
        HashMap<Integer, Integer> vm = new HashMap<>();
        
        for(int num: nums){
            am.put(num, am.getOrDefault(num, 0) + 1);
        }
        
        for(int num: nums){
            if(am.get(num) == 0) continue;
            
            if(vm.containsKey(num)){ // put in existing subsequence
                vm.put(num, vm.get(num) - 1);
                if(vm.get(num) == 0){
                    vm.remove(num);
                }
                am.put(num, am.get(num) - 1);
                vm.put(num+1, vm.getOrDefault(num+1, 0) + 1);
            }else{   // start new Subsequence
                if(am.containsKey(num+1) && am.containsKey(num+2) && am.get(num+2) > 0 && am.get(num+1) > 0){
                    am.put(num, am.get(num) - 1);
                    am.put(num+1, am.get(num+1) - 1);
                    am.put(num+2, am.get(num+2) - 1);
                    vm.put(num+3, vm.getOrDefault(num+3, 0) + 1);
                }else{
                    return false;
                }                
            }
        }
        
        return true;
    }
}