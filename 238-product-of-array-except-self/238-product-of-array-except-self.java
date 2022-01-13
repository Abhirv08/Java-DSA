class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
         int[] ans = new int[n];
        for(int i=0; i< n; i++){
            if(i!=0){
                ans[i] = nums[i]*ans[i-1];
            }else{
                ans[i] = nums[i];
            }
        }
        int product = 1;
        for(int i = n-1; i>=0; i--){
            if(i==n-1){
                ans[i] = ans[i-1];
            }else if(i==0){
                ans[0] = product;
            }else{
                ans[i] = ans[i-1]*product;
            }
                product *= nums[i];
        }
        return ans;
    }
}