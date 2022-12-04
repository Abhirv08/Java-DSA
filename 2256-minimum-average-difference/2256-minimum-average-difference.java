class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        
        long prefixSum = 0;
        long totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        
        int minAvgDiff = Integer.MAX_VALUE;
        int ans = -1;
        
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            long leftAvg = prefixSum;
            leftAvg /= (i+1);
            
            long rightAvg = (totalSum - prefixSum);
            if(i != n-1){
                rightAvg /= (n-1-i);
            }
            
            int currDiff = (int)Math.abs(leftAvg - rightAvg);
            if(currDiff < minAvgDiff){
                minAvgDiff = currDiff;
                ans = i;
            }
        }
        
        return ans;
    }
}

