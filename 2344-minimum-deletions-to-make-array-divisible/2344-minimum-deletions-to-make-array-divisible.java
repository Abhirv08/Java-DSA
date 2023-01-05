class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int num = numsDivide[0];
        for(int i = 1; i < numsDivide.length; i++){
            num = gcd(num, numsDivide[i]);
        }
        
        //System.out.println(num);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int deletions = 0;
        for(int key: map.keySet()){
            if(num%key == 0){
                break;
            }else{
                deletions += map.get(key);
            }
        }
        
        return deletions == nums.length ? -1 : deletions;
    }
    
    int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        
        return gcd(num2, num1%num2);
    }
}