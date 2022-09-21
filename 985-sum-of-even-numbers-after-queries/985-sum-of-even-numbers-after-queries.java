class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for(int num: nums){
            if((num&1) == 0){
                evenSum += num;
            }
        }
        
        int[] ans = new int[queries.length];
    
        for(int i = 0; i < queries.length; i++){
            int val = queries[i][0];
            int index = queries[i][1];
            
            if(Math.abs(nums[index])%2 == 0){
                evenSum -= nums[index];
            }
            
            nums[index] += val;
            
            if(Math.abs(nums[index])%2 == 0){
                evenSum += nums[index];
            }
            
            ans[i] = evenSum;
        }
        
        return ans;
    }
}