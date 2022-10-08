class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int minDiffSum = 0;
        
        for(int i = 0; i < nums.length; i++){
            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                
                if(sum == target) return target;
                else if(sum > target){
                    end--;
                }else{
                    start++;
                }
                
                int currDiff = Math.abs(target - sum);
                if(currDiff < diff){
                    diff = currDiff;
                    minDiffSum = sum;
                }
            }
            
        }
        
        
        return minDiffSum;
    }
}