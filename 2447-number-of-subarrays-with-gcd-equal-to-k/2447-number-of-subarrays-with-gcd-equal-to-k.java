class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int subarrays = 0;
        for(int i = 0; i < nums.length; i++){
            int currGCD = nums[i];
            for(int j = i; j < nums.length; j++){
                currGCD = gcd(currGCD, nums[j]);
                if(currGCD < k){
                    break;
                }
                if(currGCD == k){
                    subarrays++;
                }
            }
        }
        
        return subarrays;
    }
    
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
}