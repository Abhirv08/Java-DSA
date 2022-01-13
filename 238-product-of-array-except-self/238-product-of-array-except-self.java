class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
         int[] ans = new int[n];
        int[] left = new int[n];
        for(int i=0; i< n; i++){
            if(i!=0){
                left[i] = nums[i]*left[i-1];
            }else{
                left[i] = nums[i];
            }
        }
        int[] right = new int[n];
        for(int i = n-1; i>=0; i--){
            if(i==n-1){
                right[i] = nums[i];
            }else{
                right[i] = nums[i]*right[i+1];
            }
        }
        for(int i = n-1; i>=0; i--){
            if(i==n-1){
                ans[i] = left[i-1];
            }else if(i==0){
                ans[0] = right[i+1];
            }else{
                ans[i] = left[i-1]*right[i+1];
            }                
        }
        return ans;
    }
}