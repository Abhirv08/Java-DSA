class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int num = numsDivide[0];
        for(int i = 1; i < numsDivide.length; i++){
            num = gcd(num, numsDivide[i]);
        }
        
        Arrays.sort(nums);
        if(num < nums[0]) return -1;
        int deletions = 0;
        for(int i = 0; i < nums.length; ){
            if(num%nums[i] == 0) return deletions;
            
            while(i < nums.length && num%nums[i] != 0){
                deletions++;
                i++;
            }
        }
        
        return -1;
    }
    
    int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        
        return gcd(num2, num1%num2);
    }
}