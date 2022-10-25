class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int subarrays = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int gcd = findGCD(nums, i, j);
                if(gcd < k){
                    break;
                }
                if(gcd == k){
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
 
    static int findGCD(int arr[], int i, int j)
    {
        int result = arr[i];
        for (; i <= j; i++){
            result = gcd(result, arr[i]);
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }
    
}